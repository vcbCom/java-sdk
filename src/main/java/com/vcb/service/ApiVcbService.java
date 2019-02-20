package com.vcb.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import com.vcb.domain.Depth;
import com.vcb.domain.JsonResult;
import com.vcb.domain.QueryResponse;
import com.vcb.domain.Ticker;
import com.vcb.domain.request.AccountTransferRequest;
import com.vcb.domain.request.AssetDetailRequest;
import com.vcb.domain.request.AssetRecordRequest;
import com.vcb.domain.request.EntrustInfoRequest;
import com.vcb.domain.request.EntrustListRequest;
import com.vcb.domain.request.EntrustRequest;
import com.vcb.domain.request.LoanApplyInitRequest;
import com.vcb.domain.request.RealtimeJsonRequest;
import com.vcb.domain.request.SymbolRequest;
import com.vcb.domain.request.TradeLoanListRequest;
import com.vcb.domain.request.TradeLoanRequest;
import com.vcb.domain.request.TradeLoanReturnInfoRequest;
import com.vcb.domain.request.TradeLoanReturnRequest;
import com.vcb.domain.request.TradeRecordRequest;
import com.vcb.domain.response.BaseRecordResponse;
import com.vcb.domain.response.EntrustInfoResponse;
import com.vcb.domain.response.EntrustResponse;
import com.vcb.domain.response.ExchangeSymbol;
import com.vcb.domain.response.LoanApplyInitResponse;
import com.vcb.domain.response.LoanInterestResponse;
import com.vcb.domain.response.PledgeRateResponse;
import com.vcb.domain.response.SymbolInfoResponse;
import com.vcb.domain.response.TradeEntrustInitResponse;
import com.vcb.domain.response.TradeEntrustInitResponse.EntrustInfo;
import com.vcb.domain.response.TradeLoanInfo;
import com.vcb.domain.response.TradeLoanInitResponse;
import com.vcb.domain.response.TradeLoanInterestResponse;
import com.vcb.domain.response.TradeLoanReturnInitResponse;
import com.vcb.domain.response.TradeRecordResponse;
import com.vcb.exception.ApiVcbException;
import com.vcb.exception.InvalidParameterException;
import com.vcb.utils.ApiIdentityUtil;
import com.vcb.utils.HttpUtil;
import com.vcb.utils.ValidatorHelper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

/**
 * 订单相关
 *
 * @see <a href="https://github.com/vcbCom/vcbApi/wiki" target="_top">API文档</a>
 */
@Slf4j
public class ApiVcbService {
    /**
     * 秘匙
     */
    private final String ACCESS_KEY_ID;

    /**
     * 秘钥
     */
    private final String ACCESS_KEY_SECRET;

    /**
     * 服务器地址
     */
    private final String HOST;
    /**
     * 协议+ HOST
     */
    private final String DOMAIN;

    /**
     * httpClient
     */
    private final HttpClient httpClient;

    /**
     * 构造方法
     *
     * @param accessKeyId     秘匙
     * @param accessKeySecret 秘钥
     * @param vcbDomain otc域名全称
     */
    public ApiVcbService(@NonNull String accessKeyId, @NonNull String accessKeySecret, @NonNull String vcbDomain) {
        this.ACCESS_KEY_ID = accessKeyId;
        this.ACCESS_KEY_SECRET = accessKeySecret;
        this.httpClient = HttpUtil.getHttpClient();
        vcbDomain = vcbDomain.endsWith("/") ? vcbDomain.substring(0, vcbDomain.length() - 1) : vcbDomain;
        this.HOST = getHost(vcbDomain);
        this.DOMAIN = vcbDomain;
    }

    /**
     * 自带httpClient构造方法
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @param httpClient      指定httpClient
     */
    public ApiVcbService(@NonNull String accessKeyId, @NonNull String accessKeySecret, @NonNull String vcbDomain, @NonNull HttpClient httpClient) {
        this.ACCESS_KEY_ID = accessKeyId;
        this.ACCESS_KEY_SECRET = accessKeySecret;
        this.httpClient = httpClient;
        vcbDomain = vcbDomain.endsWith("/") ? vcbDomain.substring(0, vcbDomain.length() - 1) : vcbDomain;
        this.HOST = getHost(vcbDomain);
        this.DOMAIN = vcbDomain;
    }

    /**
     * 获取资产详情
     *
     */
    public void assetDetail(AssetDetailRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params = ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/asset/detail";
        log.info("assetDetail,request={}", request);
        baseCall(uri, params);
    }

    /**
     * 借贷申请初始化
     */
    public List<LoanApplyInitResponse> loanApplyInit(LoanApplyInitRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params = ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/loan/apply/init";
        log.info("loanInit,request={}", request);
        return callForList(uri, params, LoanApplyInitResponse.class);
    }

    /**
     * 质押借贷比例
     */
    public PledgeRateResponse loanRate(LoanApplyInitRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params = ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/loan/rate";
        log.info("loanRate,request={}", request);
        return call(uri, params, PledgeRateResponse.class);
    }

    /**
     * 资金划转
     *
     */
    public void assetTransfer(AccountTransferRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params = ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/asset/transfer";
        log.info("assetTransfer,request={}", request);
        baseCall(uri, params);
    }

    /**
     * 资金记录
     */
    public QueryResponse<BaseRecordResponse> assetRecord(AssetRecordRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params = ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/asset/record";
        log.info("assetRecord,request={}");
        return call(uri, params, new TypeReference<QueryResponse<BaseRecordResponse>>(){});
    }

    /****************************杠杆交易相关***************************************/

    /**
     * 交易对资金记录
     */
    public QueryResponse<TradeRecordResponse> tradeRecord(TradeRecordRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params = ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/asset/trade/record";
        log.info("tradeRecord,request={}");
        return call(uri, params, new TypeReference<QueryResponse<TradeRecordResponse>>(){});
    }

    /**
     * 交易对列表
     */
    public List<ExchangeSymbol> symbolList() {
        Map<String, String> params = new HashMap<>(5);
        String uri = "/v1/api0/kushen/trade/symbol/list";
        log.info("symbolList,request={}");
        return callForList(uri, params, ExchangeSymbol.class);
    }

    /**
     * 交易对详情
     */
    public SymbolInfoResponse symbolInfo(SymbolRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/symbol/info";
        log.info("symbolInfo,request={}",request);
        return call(uri, params, SymbolInfoResponse.class);
    }

    /**
     * 借贷申请初始化
     */
    public TradeLoanInitResponse loanInit(SymbolRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/loan/init";
        log.info("loanInit,request={}",request);
        return call(uri, params, TradeLoanInitResponse.class);
    }

    /**
     * 借贷利率
     */
    public TradeLoanInterestResponse tradeInterest(SymbolRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/loan/interest";
        log.info("tradeInterest,request={}",request);
        return call(uri, params, TradeLoanInterestResponse.class);
    }

    /**
     * 质押借贷利率
     */
    public LoanInterestResponse loanInterest(LoanApplyInitRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/loan/interest";
        log.info("tradeInterest,request={}",request);
        return call(uri, params, LoanInterestResponse.class);
    }

    /**
     * 借贷申请
     * @return 借贷订单流水号
     */
    public JsonResult loan(TradeLoanRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/loan";
        log.info("loan,request={}",request);
        return baseCall(uri, params);
    }

    /**
     * 借贷申请记录
     */
    public QueryResponse<TradeLoanInfo> loanList(TradeLoanListRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/loan/list";
        log.info("loanList,request={}",request);
        return call(uri, params, new TypeReference<QueryResponse<TradeLoanInfo>>(){});
    }


    /**
     * 借币归还初始化
     */
    public TradeLoanReturnInitResponse returnInit(TradeLoanReturnInfoRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/loan/return/init";
        log.info("returnInit,request={}",request);
        return call(uri, params, TradeLoanReturnInitResponse.class);
    }

    /**
     * 借币归还
     */
    public void loanReturn(TradeLoanReturnRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/loan/return";
        log.info("loanReturn,request={}",request);
        baseCall(uri, params);
    }

    /**
     * 交易委托初始化
     */
    public TradeEntrustInitResponse entrustInit(SymbolRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/entrust/init";
        log.info("entrustInit,request={}",request);
        return call(uri, params, new TypeReference<TradeEntrustInitResponse>(){});
    }

    /**
     * 交易委托
     */
    public EntrustResponse entrust(EntrustRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/entrust";
        log.info("entrust,request={}",request);
        return call(uri, params, EntrustResponse.class);
    }

    /**
     * 委托列表
     */
    public QueryResponse<EntrustInfo> entrustList(EntrustListRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/entrust/list";
        log.info("entrustList,request={}",request);
        return call(uri, params, new TypeReference<QueryResponse<EntrustInfo>>(){});
    }

    /**
     * 委托成交详情
     */
    public EntrustInfoResponse entrustInfo(EntrustInfoRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/entrust/info";
        log.info("entrustInfo,request={}",request);
        return call(uri, params, EntrustInfoResponse.class);
    }

    /**
     * 委托撤销
     */
    public EntrustInfo entrustCancel(EntrustInfoRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/v1/api/kushen/trade/entrust/cancel";
        log.info("entrustCancel,request={}",request);
        return call(uri, params, EntrustInfo.class);
    }

    /**
     * 获取实时交易信息
     */
    public Ticker getRealtimeTick(RealtimeJsonRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/market/tick/realtimeJson";
        log.info("getRealtimeTick,request={}",request);
        return callUnsigned(uri, params, Ticker.class);
    }

    /**
     * 获取实时深度信息
     */
    public Depth getRealtimeDepth(RealtimeJsonRequest request) {
        ValidatorHelper.validator(request);
        Map<String, String> params =ApiIdentityUtil.toMap(request);
        String uri = "/market/depth/realtimeJson";
        log.info("getRealtimeDepth,request={}",request);
        return callUnsigned(uri, params, Depth.class);
    }

    private <T> T call(String uri, Map<String, String> params, Class<T> clazz) {
        return baseCall(uri, params).getBody().toJavaObject(clazz);
    }
    private <T> T callUnsigned(String uri, Map<String, String> params, Class<T> clazz) {
        return baseCallUnsigned(uri, params).getBody().toJavaObject(clazz);
    }

    private <T> List<T> callForList(String uri, Map<String, String> params, Class<T> clazz) {
        return ((JSONArray)baseCall(uri, params).getBody()).toJavaList(clazz);
    }

    private <T> T call(String uri, Map<String, String> params, TypeReference<T> typeReference) {
        return JSON.parseObject(baseCall(uri, params).getBody().toJSONString(), typeReference);
    }

    /**
     * 生成签名的url并发起请求
     * @param uri 接口uri
     * @param params 参数
     * @return
     */
    private JsonResult<JSON> baseCall(String uri, Map<String, String> params) {
        ApiIdentityUtil.sign(ACCESS_KEY_ID, ACCESS_KEY_SECRET, "1", ApiIdentityUtil.gmtNow(), HttpPost.METHOD_NAME,
            HOST, uri, params);
        String json = JSON.toJSONString(params);
        log.info("requestData={}", json);
        HttpPost httpPost = new HttpPost(DOMAIN + uri);
        httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        JsonResult<JSON> jsonResult = postRequest(httpPost);
        return jsonResult;
    }

    /**
     * 无需签名的post请求
     * @param uri
     * @param params
     * @return
     */
    private JsonResult<JSON> baseCallUnsigned(String uri, Map<String, String> params) {
        log.info("requestData={}", JSON.toJSONString(params));
        HttpPost httpPost = new HttpPost(DOMAIN + uri);
        ArrayList<BasicNameValuePair> basicNameValuePairs = new ArrayList<>(params.size());
        for (String k : params.keySet()) {
            basicNameValuePairs.add(new BasicNameValuePair(k, params.get(k)));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(basicNameValuePairs, StandardCharsets.UTF_8));
        return postRequest(httpPost);
    }

    private JsonResult<JSON> postRequest(HttpPost httpPost) {
        String responseData;
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            InputStream inputStream = httpResponse.getEntity().getContent();
            responseData = IOUtils.toString(inputStream);
            inputStream.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ApiVcbException("HttpClient IOException");
        }
        log.info("responseData={}", responseData);
        JsonResult<JSON> jsonResult = JSON.parseObject(responseData, new TypeReference<JsonResult<JSON>>() {});
        if (200 != jsonResult.getCode()) {
            throw new ApiVcbException("call vcb service error");
        }
        return jsonResult;
    }

    /**
     * 获取host (签名需要)
     * @param vcbDomain
     * @return
     */
    private String getHost(String vcbDomain) {
        String urlPattern = "^((https|http)://)"
            + "(([0-9]{1,3}\\.){3}[0-9]{1,3}"
            + "|"
            + "([0-9a-z_!~*'()-]+\\.)*"
            + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\."
            + "[a-z]{2,6})"
            + "(:[0-9]{1,5})?";
        boolean matches = Pattern.compile(urlPattern).matcher(vcbDomain).matches();
        if (!matches) {
            throw new InvalidParameterException("vcbDomain");
        }
        String[] split = vcbDomain.split("//");
        return split[1];
    }


}
