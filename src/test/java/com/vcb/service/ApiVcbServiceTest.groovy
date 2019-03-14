package com.vcb.service

import com.alibaba.fastjson.JSON
import com.vcb.domain.request.*
import org.apache.commons.lang3.StringUtils
import spock.lang.Specification

class ApiVcbServiceTest extends Specification {

    private static ApiVcbService apiVcbService

    private static String mobile = "17316227689"

    void setup() {
        apiVcbService = new ApiVcbService("ivpdru4c-qpdqswld-yx9atr8t-t7763","89j2t90o-76fhxpc2-3vz0fh18-j2471","http://te.vcb.com")
    }

    /**
     * 获取资产详情
     */
    def "assetDetail"() {
        def request = new AssetDetailRequest()
        request.openid = mobile
//        request.type = "loan"
        apiVcbService.assetDetail(request)
        expect: true
    }

    /**
     * 借贷申请初始化
     */
    def "loanApplyInit"() {
        def request = new LoanApplyInitRequest()
        request.openid = mobile
        request.varietyCode = "btc"
        def response = apiVcbService.loanApplyInit(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借贷申请初始化
     */
    def "loanApply"() {
        def request = new LoanApplyRequest()
        request.openid = mobile
        request.depositVarietyCode = "btc"
        request.depositAmount=0.1
        request.loanAmount=100
        request.mobile= mobile
        def response = apiVcbService.loanApply(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 质押借贷比例
     */
    def "loanRate"() {
        def request = new LoanApplyInitRequest()
        request.openid = "17316227689"
        request.varietyCode = "btc"
        def response = apiVcbService.loanRate(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 资金划转
     */
    def "assetTransfer"() {
        def request = new AccountTransferRequest()
        request.mobile = "17316227689"
        request.type = "loan"
        request.amount = "10"
        request.direct="in"
        request.varietyCode="usdt"
        def response = apiVcbService.assetTransfer(request)
        expect: true
    }

    /**
     * 资金记录
     */
    def "assetRecord"() {
        def request = new AssetRecordRequest()
        request.openid = "CDR20MDAwMDAwMDAwMTA1MzU2E52A820"
        request.type = 2
        apiVcbService.assetRecord(request)
        expect: true
    }

    /**
     * 允许借贷的列表
     */
    def "loanVariety"() {
        def response = apiVcbService.loanVariety()
        expect: true
    }

    /**
     * 理财购买初始化
     */
    def "buyInit"() {
        def request = new FinancingSnRequest()
        request.openid = mobile
        request.financingSn="LC00000"
        apiVcbService.buyInit(request)
        expect: true
    }
/*********************活期理财交易****************************/
    /**
     * 产品列表
     */
    def "financingList"() {
        def request = new SearchCurrentFinancingRequest()
        request.openid = mobile
        apiVcbService.financingList(request)
        expect: true
    }

    /**
     * 产品详情
     */
    def "detail"() {
        def request = new CurrentFinancingDeatilRequest()
        request.openid = mobile
        request.currentFinancingSn = "CF00000004"
        apiVcbService.detail(request)
        expect: true
    }

    /**
     * 已购产品列表
     */
    def "myFinancingList"() {
        def request = new SearchCurrentFinancingRequest()
        request.openid = mobile
        apiVcbService.myFinancingList(request)
        expect: true
    }

    /**
     * init
     */
    def "init"() {
        def request = new LoanApplyInitRequest()
        request.openid = mobile
        apiVcbService.init(request)
        expect: true
    }
    /**
     * 已购产品列表
     */
    def "financingRecordList"() {
        def request = new CurrentFinancingRecordRequest()
        request.openid = mobile
        request.startTime = new Date().toLocaleString()
//        request.endTime = new Date().toLocaleString()
        apiVcbService.financingrecordList(request)
        expect: true
    }
    /**
     * 投资
     */
    def "buy"() {
        def request = new CurrentFinancingBuyRequest()
        request.openid = mobile
        request.amount = BigDecimal.TEN
        request.currentFinancingSn = "CF00000013"
        apiVcbService.buy(request)
        expect: true
    }
    /**
     * 赎出
     */
    def "sell"() {
        def request = new CurrentFinancingSellRequest()
        request.openid = BigDecimal.ONE
        request.currentFinancingSn = "CF00000010"
        apiVcbService.sell(request)
        expect: true
    }

/*********************杠杆交易****************************/
    /**
     * 交易对资金记录
     */
    def "tradeRecord"() {
        def request = new TradeRecordRequest()
        request.openid = "CDR20MDAwMDAwMDAwMTA1MTAy30D00AE"
//        request.symbol = "btcusdt"
        apiVcbService.tradeRecord(request)
        expect: true
    }

    /**
     * 交易对列表
     */
    def "symbolList"() {
        def response = apiVcbService.symbolList()
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 交易对详情
     */
    def "symbolInfo"() {
        def request = new SymbolRequest()
        request.openid = mobile
        request.symbol = "btcusdt"
        request.exchangeCode = "huobi"
        def response = apiVcbService.symbolInfo(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借贷申请初始化
     */
    def "loanInit"() {
        def request = new SymbolRequest()
        request.openid = mobile
        request.symbol = "btcusdt"
        request.exchangeCode = "huobi"
        def response = apiVcbService.loanInit(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借贷利率
     */
    def "tradeInterest"() {
        def request = new SymbolRequest()
        request.openid = mobile
        request.symbol = "btcusdt"
        request.exchangeCode = "huobi"
        def response = apiVcbService.tradeInterest(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 质押借贷利率
     */
    def "loanInterest"() {
        def request = new LoanApplyInitRequest()
        request.openid = mobile
        request.varietyCode = "btc"
        def response = apiVcbService.loanInterest(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借贷申请
     */
    def "loan"() {
        def request = new TradeLoanRequest()
        request.openid = mobile
        request.mobile = mobile
        request.symbol = "btcusdt"
        request.exchangeCode = "huobi"
        request.loanVarietyCode = "btc"
        request.amount = 1
        def response = apiVcbService.loan(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借贷申请记录
     */
    def "loanList"() {
        def request = new TradeLoanListRequest()
        request.openid = "CDR20MDAwMDAwMDAwMTA1MTAy30D00AE"
//        request.symbol="btcusdt"
        request.exchangeCode="huobi"
//        request.returnStatus=4
        apiVcbService.loanList(request)
        expect: true
    }


    /**
     * 借币归还初始化
     */
    def "returnInit"() {
        def request = new TradeLoanReturnInfoRequest()
        request.openid = "CDR20MDAwMDAwMDAwMTA1MzY08DD9258"
        request.tradeLoanSn = "JD0000026"
        apiVcbService.returnInit(request)
        expect: true
    }

    /**
     * 借币归还
     */
    def "loanReturn"() {
        def request = new TradeLoanReturnRequest()
        request.openid = mobile
        request.amount = 1
        request.tradeLoanSn = "JD00000174"
        def response = apiVcbService.loanReturn(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 交易委托初始化
     */
    def "entrustInit"() {
        def request = new SymbolRequest()
        request.openid = "13011114585"
        request.exchangeCode = "huobi"
        request.symbol = "btcusdt"
        def response = apiVcbService.entrustInit(request)
        println JSON.toJSONString(response)
        StringUtils.trimToEmpty()
        expect: true
    }

    /**
     * 交易委托
     */
    def "entrust"() {
        def request = new EntrustRequest()
        request.openid = mobile
        request.exchangeCode = "huobi"
        request.symbol = "btcusdt"
        request.amount = 1
        //市价买入
        request.type = 3
        def response = apiVcbService.entrust(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 委托撤销
     */
    def "entrustCancel"() {
        def request = new EntrustInfoRequest()
        request.openid = mobile
        request.entrustSn = "WT00002158"
        def response = apiVcbService.entrustCancel(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 委托列表查询
     */
    def "entrustList"() {
        def request = new EntrustListRequest()
        request.openid = "CDR20MDAwMDAwMDAwMTEyMDAyBAD18F8"
        apiVcbService.entrustList(request)
        expect: true
    }

    /**
     * 委托成交详情
     */
    def "entrustInfo"() {
        def request = new EntrustInfoRequest()
        request.openid = mobile
        request.entrustSn = "WT00002158"
        def response = apiVcbService.entrustInfo(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 获取实时交易信息
     */
    def "getRealtimeTick"() {
        def request = new RealtimeJsonRequest()
        request.variety = "btcusdt"
        request.exchange = "huobi"
        def response = apiVcbService.getRealtimeTick(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 获取实时深度信息
     */
    def "getRealtimeDepth"() {
        def request = new RealtimeJsonRequest()
        request.variety = "btcusdt"
        request.exchange = "huobi"
        def response = apiVcbService.getRealtimeDepth(request)
        println JSON.toJSONString(response)
        expect: true
    }

    public static void main(String[] args) {
        String s = "[{\"type\":4,\"number\":\"291117124@qq.com\",\"name\":\"孟晗\",\"url\":\"http://vcb.oss-cn-hongkong.aliyuncs.com/pay/230f5b22699d6cedbcff3d5b2ed92895%21small?OSSAccessKeyId=LTAIMoSidU9xd2Nv&Signature=OHa2idYC1VcZ7zQg8fMOzIcdR84%3D&Expires=1545995402\",\"bank\":null,\"bankName\":null},{\"type\":2,\"number\":\"hb965420mh\",\"name\":\"孟晗\",\"url\":\"http://vcb.oss-cn-hongkong.aliyuncs.com/pay/87a5219c85167c3396f1cde13b7db198%21small?OSSAccessKeyId=LTAIMoSidU9xd2Nv&Signature=W5Rl8sxJYvM%2BuK3ePhvCbOW7N%2B8%3D&Expires=1545995402\",\"bank\":null,\"bankName\":null},{\"type\":3,\"number\":\"2525225252\",\"name\":\"孟晗\",\"url\":null,\"bank\":\"招商银行\",\"bankName\":\"北京大屯路招商银行\"}]"
        println s.length()
    }

    def "assetTransfer2"() {
        int[] test = [1,2,1]
        def var = test[0]
        for (int i = 1; i < test.length; i++) {
            var^=test[i]
        }
        println var
        println 1^2

        long workerMask= -1L ^ (-1L << 5);
        println Long.toBinaryString(workerMask)
        println Long.toBinaryString(-1)
        def decimal = new BigDecimal("0.365")
        println decimal
        expect: true
    }
}
