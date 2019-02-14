package com.vcb.service

import com.alibaba.fastjson.JSON
import com.vcb.domain.request.*
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
        request.mobile = "17316227689"
        request.type = "loan"
        apiVcbService.assetDetail(request)
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

    /*********************杠杆交易****************************/
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
        request.mobile = mobile
        request.symbol = "btcusdt"
        request.exchangeCode = "huobi"
        apiVcbService.symbolInfo(request)
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
     * 借贷申请
     */
    def "loan"() {
        def request = new TradeLoanRequest()
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
        request.mobile = mobile
        def response = apiVcbService.loanList(request)
        println JSON.toJSONString(response)
        expect: true
    }


    /**
     * 借币归还初始化
     */
    def "returnInit"() {
        def request = new TradeLoanReturnInfoRequest()
        request.mobile = mobile
        request.tradeLoanSn = "JD00000174"
        def response = apiVcbService.returnInit(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借币归还
     */
    def "loanReturn"() {
        def request = new TradeLoanReturnRequest()
        request.mobile = mobile
        request.amount = 1
        request.tradeLoanSn = "JD00000174"
        def response = apiVcbService.loanReturn(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 借贷归还明细
     */
    def "returnInfo"() {
        def request = new TradeLoanReturnInfoRequest()
        request.mobile = mobile
        request.tradeLoanSn = "JD00000174"
        def response = apiVcbService.returnInfo(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 交易委托初始化
     */
    def "entrustInit"() {
        def request = new SymbolRequest()
        request.mobile = mobile
        request.exchangeCode = "huobi"
        request.symbol = "btcusdt"
        def response = apiVcbService.entrustInit(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 交易委托
     */
    def "entrust"() {
        def request = new EntrustRequest()
        request.mobile = mobile
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
        request.mobile = mobile
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
        request.mobile = mobile
        def response = apiVcbService.entrustList(request)
        println JSON.toJSONString(response)
        expect: true
    }

    /**
     * 委托成交详情
     */
    def "entrustInfo"() {
        def request = new EntrustInfoRequest()
        request.mobile = mobile
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
}
