package precipitated.will.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by will.wang on 2015/12/30.
 */
public class JsonAndMap {

    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "    \"flag\": true,\n" +
                "    \"status\": 0,\n" +
                "    \"msg\": \"成功\",\n" +
                "    \"train\": {\n" +
                "      \"trainNumber\": \"K205/K208\",\n" +
                "      \"date\": \"2016-01-20\",\n" +
                "      \"week\": \"星期三\",\n" +
                "      \"trainType\": \"快速\",\n" +
                "      \"dStation\": \"兖州\",\n" +
                "      \"dStationInfo\": false,\n" +
                "      \"dTime\": \"23:09\",\n" +
                "      \"dTimeStr\": \"201601202309\",\n" +
                "      \"aStation\": \"安康\",\n" +
                "      \"aStationInfo\": false,\n" +
                "      \"aTime\": \"17:58\",\n" +
                "      \"aTimeStr\": \"201601211758\",\n" +
                "      \"time\": \"1129\",\n" +
                "      \"timeInMinute\": 0,\n" +
                "      \"dayAfter\": \"+1\",\n" +
                "      \"sort\": 0,\n" +
                "      \"trainStatus\": 0,\n" +
                "      \"distance\": \"1384\",\n" +
                "      \"extra\": {\n" +
                "        \n" +
                "      },\n" +
                "      \"remainTicket\": \"\",\n" +
                "      \"remainTicketColor\": 0,\n" +
                "      \"remainTicketCount\": 0,\n" +
                "      \"remainTicketBackgroundColor\": 0,\n" +
                "      \"isPreOrder\": false,\n" +
                "      \"depWeek\": \"周三\",\n" +
                "      \"depDataValue\": \"01-20\",\n" +
                "      \"arrWeek\": \"周四\",\n" +
                "      \"arrDataValue\": \"01-21\",\n" +
                "      \"timeCost\": \"耗时18小时49分\",\n" +
                "      \"remainTicketType\": 0,\n" +
                "      \"trainShowDescColor\": -1\n" +
                "    },\n" +
                "    \"agentId\": 370,\n" +
                "    \"agentName\": \"易票网\",\n" +
                "    \"tickets\": [\n" +
                "      {\n" +
                "        \"ticketId\": \"0\",\n" +
                "        \"type\": \"无座\",\n" +
                "        \"price\": 168.50,\n" +
                "        \"count\": 0,\n" +
                "        \"paperAccept\": 0\n" +
                "      }\n" +
                "    ],\n" +
                "    \"insuranceMax\": 3,\n" +
                "    \"insuranceMin\": 0,\n" +
                "    \"insurancePrice\": 20,\n" +
                "    \"insuranceCode\": \"DEFAULT\",\n" +
                "    \"insuranceDefault\": 1,\n" +
                "    \"buyChildTicketTip\": \"儿童票和学生票暂收成人票价，出票后退差价\",\n" +
                "    \"acceptSeatTip\": \"无票时，购买备选票，卧铺上中下铺随机分配，暂收下铺价格，出票后退差额。\",\n" +
                "    \"buyTicketTips\": \"1.因火车票票源紧张，努力为您出票，若未能给您出票，将立即退款，敬请谅解。退款到帐时间为3-21天（15个工作日内，视银行不同有所差异）。rn2.去哪儿网客户端目前暂不支持购买儿童票，请在电脑上登陆www.qunar.com购买。\",\n" +
                "    \"seatTips\": \"选择备选座席将收取预收费用，即最贵的备选座席和首选座席的差价。实际出票后，多余预收款将全额退还给您。rn卧铺上中下铺是随机分配的，预订时暂收下铺价格，出票后根据实际票价退差价。\",\n" +
                "    \"invoiceInfo\": {\n" +
                "      \"invoiceType\": [\n" +
                "        {\n" +
                "          \"name\": \"保险发票\",\n" +
                "          \"value\": 1\n" +
                "        }\n" +
                "      ],\n" +
                "      \"invoiceGetType\": [\n" +
                "        {\n" +
                "          \"name\": \"平邮\",\n" +
                "          \"value\": 1,\n" +
                "          \"price\": 0\n" +
                "        }\n" +
                "      ],\n" +
                "      \"warmTips\": \"发车后第二天，保险公司平信免费邮寄。\"\n" +
                "    },\n" +
                "    \"buyTicketMax\": 5,\n" +
                "    \"warmTips\": \"\",\n" +
                "    \"checkTicket\": \"0\",\n" +
                "    \"insuranceInfo\": {\n" +
                "      \"insuranceProducts\": [\n" +
                "        {\n" +
                "          \"insuranceCorpCode\": \"BN\",\n" +
                "          \"productCode\": \"300295\",\n" +
                "          \"price\": \"20\",\n" +
                "          \"name\": \"20元保险\",\n" +
                "          \"desc\": \"80万保障，出票优先\",\n" +
                "          \"selected\": true\n" +
                "        },\n" +
                "        {\n" +
                "          \"insuranceCorpCode\": \"BN\",\n" +
                "          \"productCode\": \"300686\",\n" +
                "          \"price\": \"30\",\n" +
                "          \"name\": \"30元保险\",\n" +
                "          \"desc\": \"155万保障，极速出票\",\n" +
                "          \"selected\": false\n" +
                "        },\n" +
                "        {\n" +
                "          \"insuranceCorpCode\": \"HZ\",\n" +
                "          \"productCode\": \"QNT006\",\n" +
                "          \"price\": \"5\",\n" +
                "          \"name\": \"5元保险\",\n" +
                "          \"desc\": \"60万保障，出票靠前\",\n" +
                "          \"selected\": false\n" +
                "        },\n" +
                "        {\n" +
                "          \"insuranceCorpCode\": \"NO\",\n" +
                "          \"productCode\": \"000000\",\n" +
                "          \"alertWindow\": {\n" +
                "            \"content\": \"小驼将帮您向泰康等保险公司申请一份赠险，一定几率可获得哟~\",\n" +
                "            \"buttons\": [\n" +
                "              {\n" +
                "                \"type\": 3,\n" +
                "                \"text\": \"不要\",\n" +
                "                \"throughOgnl\": {\n" +
                "                  \"0gnl.acceptInsuranceGift\": false\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"type\": 3,\n" +
                "                \"text\": \"可以\",\n" +
                "                \"throughOgnl\": {\n" +
                "                  \"0gnl.acceptInsuranceGift\": true\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          \"price\": \"0\",\n" +
                "          \"name\": \"不购买\",\n" +
                "          \"desc\": \"出票较慢，需要排队\",\n" +
                "          \"selected\": false\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"isPreOrder\": false,\n" +
                "    \"deliveryPaperInfo\": {\n" +
                "      \"isSupportPaper\": true,\n" +
                "      \"servicePrice\": \"5\",\n" +
                "      \"paperAlertMsg\": \"配送票如需退改，请开车前持购票证件到车站办理。\",\n" +
                "      \"paperMsg\": \"尽量购买连号票，无法保证100%购买成功。\",\n" +
                "      \"deliveryWays\": [\n" +
                "        {\n" +
                "          \"expressName\": \"顺丰速运\",\n" +
                "          \"expressCode\": \"shunfeng\",\n" +
                "          \"expressPrice\": \"20\",\n" +
                "          \"discountPrice\": \"0\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"hint\": true\n" +
                "    },\n" +
                "    \"jumpTarget\": 0,\n" +
                "    \"preVerify\": true,\n" +
                "    \"faqName\": \"取票、退票须知\",\n" +
                "    \"paperSupportSeat\": false,\n" +
                "    \"userBindInfo\": {\n" +
                "      \"isSupportBind\": true,\n" +
                "      \"desc\": \"极速出票 售后无忧\"\n" +
                "    },\n" +
                "    \"extra\": {\n" +
                "      \"bizMode\": \"0\"\n" +
                "    },\n" +
                "    \"appClientOccupy\": false,\n" +
                "    \"discountPrice\": \"0\"\n" +
                "  }";

        Map<String, Object> map = JSON.parseObject(jsonStr, Map.class);

//        System.out.println(map);

        Object data = map.get("deliveryPaperInfo");
//        System.out.println(data);

        String dataStr = JSON.toJSONString(data);
        JSONObject dataJsonObject = JSONObject.parseObject(dataStr);

        Object deliveryWays = dataJsonObject.get("deliveryWays");
        System.out.println(((List)deliveryWays).get(0));
    }
}
