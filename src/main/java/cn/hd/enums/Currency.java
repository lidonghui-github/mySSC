package cn.hd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 币种

 */
public enum Currency {

    人民币("001","人民币"),//CNY
    台币("010","台币"),//TCD
    英镑("012","英镑"),//POUND
    港币("013","港币"),//HK_DOLL
    美元("014","美元"),//DOLL
    瑞士法郎("015","瑞士法郎"),//SWI_FRA
    德国马克("016","德国马克"),//GER_MARK
    法国法郎("017","法国法郎"),//FREN_FRAN
    新加坡元("018","新加坡元"),//SGP_DOLL
    荷兰盾("020","荷兰盾"),//NLG
    瑞典克朗("021","瑞典克朗"),//SEK
    丹麦克朗("022","丹麦克朗"),//DKK
    挪威克朗("023","挪威克朗"),//NOK
    奥地利先令("024","奥地利先令"),//ATS
    比利时法郎("025","比利时法郎"),//BEF
    意大利里拉("026","意大利里拉"),//ITL
    日元("027","日元"),//JPY
    加拿大元("028","加拿大元"),//CAD
    澳大利亚元("029","澳大利亚元"),//AUD
    阿尔及利亚第纳尔("030","阿尔及利亚第纳尔"),//DZD
    马来西亚林吉特("032","马来西亚林吉特"),//MYR
    欧洲货币单位("033","欧洲货币单位"),//ECU
    纳米比亚南非兰特("034","纳米比亚南非兰特"),//NAR
    尼日利亚奈拉("035","尼日利亚奈拉"),//NGN
    赛普路斯镑("036","赛普路斯镑"),//CYP
    孟加拉塔卡("037","孟加拉塔卡"),//BDT
    泰国铢("038","泰国铢"),//THP
    希腊德拉克马("039","希腊德拉克马"),//GRD
    尼泊尔卢布("040","尼泊尔卢布"),//NPR
    芬兰马克("042","芬兰马克"),//FIM
    巴基斯坦卢比("043","巴基斯坦卢比"),//PRK
    埃塞俄比亚比尔("044","埃塞俄比亚比尔"),//ETB
    斯里兰卡卢比("045","斯里兰卡卢比"),//LKR
    阿联酋迪拉姆("046","阿联酋迪拉姆"),//AED
    博茨瓦纳普拉("047","博茨瓦纳普拉"),//BWP
    菲律宾比索("048","菲律宾比索"),//PHP
    约旦第纳尔("049","约旦第纳尔"),//JOD
    斯威士兰里兰吉尼("050","斯威士兰里兰吉尼"),//SZL
    欧元("051","欧元"),//EUR
    埃及镑("052","埃及镑"),//EGP
    卡塔尔里亚尔("053","卡塔尔里亚尔"),//QAR
    非洲金融共同体法郎("054","非洲金融共同体法郎"),//XOF
    坦桑尼亚先令("055","坦桑尼亚先令"),//TZS
    几内亚共和国法郎("056","几内亚共和国法郎"),//GNF
    图格里克("057","图格里克"),//MNT
    安哥拉宽扎("058","安哥拉宽扎"),//AOA
    阿曼里亚尔("059","阿曼里亚尔"),//OMR
    肯尼亚镑("060","肯尼亚镑"),//KEP
    新谢克尔("061","新谢克尔"),//ILS
    新西兰元("062","新西兰元"),//NZD
    乌兹别克斯坦苏姆("063","乌兹别克斯坦苏姆"),//UZS
    毛里求斯卢比("064","毛里求斯卢比"),//MAU_RUP
    沙特里亚尔("065","沙特里亚尔"),//SAR
    兹罗提("066","兹罗提"),//PLN
    科威特第纳尔("068","科威特第纳尔"),//KWD
    巴西雷亚尔("069","巴西雷亚尔"),//BRL
    荷属安的列斯盾("070","荷属安的列斯盾"),//DUTCH_LISD
    盎司金("071","盎司金"),//OUN_GOLD
    南苏丹镑("072","南苏丹镑"),//SOUT_SUL
    盎司银("073","盎司银"),//OUN_SIL
    盎司铂("074","盎司铂"),//OUN_PLA
    澳门元("081","澳门元"),//MACAO_YUAN
    韩币("085","韩币"),//WON
    ;

    public static Currency getByCode(String code) {
        return map.get(code);
    }

    private static Map<String, Currency> map;

    static {
        map = new HashMap<String, Currency>();
        for (Currency e : Currency.values()) {
            map.put(e.getCode(), e);
        }
    }

    public boolean equals(String code) {
        return this.code.equals(code);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private final String code;
    private final String name;

    private Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
