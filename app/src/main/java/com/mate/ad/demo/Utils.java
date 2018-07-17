package com.mate.ad.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mate.ad.demo.bean.FamilyBean;
import com.mate.ad.demo.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create by fushenghua
 */
public class Utils {

    static String dataJson = "[\n" +
            "        {\n" +
            "            \"id\": 71217,\n" +
            "            \"movieName\": \"动画《绿毛怪格林奇》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/13/104438.32026910_120X90X4.jpg\",\n" +
            "            \"movieId\": 233407,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/13/mp4/180713104445024481.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/13/mp4/180713104445024481.mp4\",\n" +
            "            \"videoTitle\": \"绿毛怪格林奇　“圣诞小偷”版中文预告片\",\n" +
            "            \"videoLength\": 136,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"喜剧\",\n" +
            "                \"家庭\",\n" +
            "                \"奇幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"“小黄人”团队新作\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71214,\n" +
            "            \"movieName\": \"《的士速递5》定档预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/13/094244.40775594_120X90X4.jpg\",\n" +
            "            \"movieId\": 253904,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/13/mp4/180713094601302130.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/13/mp4/180713094601302130.mp4\",\n" +
            "            \"videoTitle\": \"的士速递5 内地定档预告\",\n" +
            "            \"videoLength\": 80,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"警探司机联手剿灭犯罪团伙\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71213,\n" +
            "            \"movieName\": \"《玛丽女王》首支预告 \",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/13/085021.15319512_120X90X4.jpg\",\n" +
            "            \"movieId\": 197804,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/13/mp4/180713085116166457.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/13/mp4/180713085116166457.mp4\",\n" +
            "            \"videoTitle\": \"玛丽女王 预告片\",\n" +
            "            \"videoLength\": 167,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"传记\",\n" +
            "                \"剧情\",\n" +
            "                \"历史\"\n" +
            "            ],\n" +
            "            \"summary\": \"聚焦英国皇室传奇恩怨\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71200,\n" +
            "            \"movieName\": \"《鸡皮疙瘩2》中字预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/12/091426.32910127_120X90X4.jpg\",\n" +
            "            \"movieId\": 240085,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/12/mp4/180712091455011841.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/12/mp4/180712091455011841.mp4\",\n" +
            "            \"videoTitle\": \"鸡皮疙瘩2：闹鬼的万圣节 中字预告1\",\n" +
            "            \"videoLength\": 46,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"恐怖\",\n" +
            "                \"喜剧\",\n" +
            "                \"奇幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"吸血鬼、狼人、女巫总动员\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71209,\n" +
            "            \"movieName\": \"《与神同行2》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/12/181443.14834163_120X90X4.jpg\",\n" +
            "            \"movieId\": 250298,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/12/mp4/180712181445380053.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/12/mp4/180712181445380053.mp4\",\n" +
            "            \"videoTitle\": \"与神同行2：因与缘 正式预告\",\n" +
            "            \"videoLength\": 120,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"剧情\",\n" +
            "                \"奇幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"河正宇变身高丽武士\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71172,\n" +
            "            \"movieName\": \"动画《奇幻游乐园》中字预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/10/085441.83696384_120X90X4.jpg\",\n" +
            "            \"movieId\": 229710,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/10/mp4/180710085334049376.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/10/mp4/180710085334049376.mp4\",\n" +
            "            \"videoTitle\": \"奇幻游乐园 先导预告片\",\n" +
            "            \"videoLength\": 109,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"冒险\",\n" +
            "                \"喜剧\",\n" +
            "                \"家庭\",\n" +
            "                \"奇幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"小女孩让废弃乐园重焕生机\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71176,\n" +
            "            \"movieName\": \"强森《摩天营救》终极预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/10/102339.28749697_120X90X4.jpg\",\n" +
            "            \"movieId\": 234573,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/10/mp4/180710102532518638.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/10/mp4/180710102532518638.mp4\",\n" +
            "            \"videoTitle\": \"摩天营救　终极预告\",\n" +
            "            \"videoLength\": 62,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"冒险\",\n" +
            "                \"剧情\"\n" +
            "            ],\n" +
            "            \"summary\": \"强森体验“飞一样的感觉”\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71173,\n" +
            "            \"movieName\": \"《流浪地球》预告片\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/10/094918.73639855_120X90X4.jpg\",\n" +
            "            \"movieId\": 218707,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/10/mp4/180710095224033982.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/10/mp4/180710095224033982.mp4\",\n" +
            "            \"videoTitle\": \"流浪地球  第三支贴片预告\",\n" +
            "            \"videoLength\": 30,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"吴京首演宇航员助力中国科幻\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71165,\n" +
            "            \"movieName\": \"《北方一片苍茫》终极预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/09/114734.43799492_120X90X4.jpg\",\n" +
            "            \"movieId\": 247420,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/09/mp4/180709114741799383.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/09/mp4/180709114741799383.mp4\",\n" +
            "            \"videoTitle\": \"北方一片苍茫 终极预告\",\n" +
            "            \"videoLength\": 94,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"剧情\"\n" +
            "            ],\n" +
            "            \"summary\": \"影片魔幻与现实交织\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71141,\n" +
            "            \"movieName\": \"徐峥《我不是药神》终极预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/05/165257.91871664_120X90X4.jpg\",\n" +
            "            \"movieId\": 242167,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/05/mp4/180705092932838816.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/05/mp4/180705092932838816.mp4\",\n" +
            "            \"videoTitle\": \"我不是药神 终极预告\",\n" +
            "            \"videoLength\": 111,\n" +
            "            \"rating\": 8.8,\n" +
            "            \"type\": [\n" +
            "                \"剧情\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"褪去幽默外衣 展现角色信念\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70500,\n" +
            "            \"movieName\": \"《超时空同居》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/05/09/152158.27491708_120X90X4.jpg\",\n" +
            "            \"movieId\": 250729,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/05/09/mp4/180509152234547829.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/05/09/mp4/180509152234547829.mp4\",\n" +
            "            \"videoTitle\": \"超时空同居 选择版预告\",\n" +
            "            \"videoLength\": 112,\n" +
            "            \"rating\": 6.8,\n" +
            "            \"type\": [\n" +
            "                \"奇幻\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71154,\n" +
            "            \"movieName\": \"韩国惊悚片《目击者》首曝预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/06/122246.96752363_120X90X4.jpg\",\n" +
            "            \"movieId\": 258707,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/06/mp4/180706122427745537.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/06/mp4/180706122427745537.mp4\",\n" +
            "            \"videoTitle\": \"目击者 预告片\",\n" +
            "            \"videoLength\": 57,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"目击杀人又被杀人犯看到\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71111,\n" +
            "            \"movieName\": \"高司令《登月第一人》首曝中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/04/083830.29801556_120X90X4.jpg\",\n" +
            "            \"movieId\": 229976,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/04/mp4/180704084202314936.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/04/mp4/180704084202314936.mp4\",\n" +
            "            \"videoTitle\": \"登月第一人 中文预告\",\n" +
            "            \"videoLength\": 150,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"传记\",\n" +
            "                \"剧情\",\n" +
            "                \"历史\"\n" +
            "            ],\n" +
            "            \"summary\": \"震撼再现登月传奇\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71112,\n" +
            "            \"movieName\": \"《有五个姐姐的我就注定要单身了啊！！》定档预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/04/100733.77302985_120X90X4.jpg\",\n" +
            "            \"movieId\": 258677,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/04/mp4/180704100752783550.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/04/mp4/180704100752783550.mp4\",\n" +
            "            \"videoTitle\": \"五个姐姐 定档预告片\",\n" +
            "            \"videoLength\": 71,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"爱情\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"改编自台湾爆红同名轻小说\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71103,\n" +
            "            \"movieName\": \"“画江湖”《风语咒》曝终极预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/03/092954.89691882_120X90X4.jpg\",\n" +
            "            \"movieId\": 256241,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/03/mp4/180703093000092174.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/03/mp4/180703093000092174.mp4\",\n" +
            "            \"videoTitle\": \"风语咒 终极预告\",\n" +
            "            \"videoLength\": 111,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"动作\",\n" +
            "                \"奇幻\",\n" +
            "                \"冒险\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"凶兽饕餮终于现身\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71090,\n" +
            "            \"movieName\": \"韩国真人版《人狼》首曝正式预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/07/01/115458.75340810_120X90X4.jpg\",\n" +
            "            \"movieId\": 200716,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/07/01/mp4/180701115403338456.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/07/01/mp4/180701115403338456.mp4\",\n" +
            "            \"videoTitle\": \"人狼 正式预告片\",\n" +
            "            \"videoLength\": 80,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"金知云改编押井守同名动画\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71075,\n" +
            "            \"movieName\": \"《墙上有一个钟的房子》预告片\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/29/093820.16247833_120X90X4.jpg\",\n" +
            "            \"movieId\": 251180,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/29/mp4/180629093641852539.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/29/mp4/180629093641852539.mp4\",\n" +
            "            \"videoTitle\": \"墙上有一个钟的房子 中文剧场版预告片\",\n" +
            "            \"videoLength\": 156,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"家庭\",\n" +
            "                \"奇幻\",\n" +
            "                \"恐怖\",\n" +
            "                \"悬疑\",\n" +
            "                \"科幻\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"大魔王大战神秘力量\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71072,\n" +
            "            \"movieName\": \"姜文《邪不压正》终极预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/29/111102.92568176_120X90X4.jpg\",\n" +
            "            \"movieId\": 223748,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/29/mp4/180629092406999986.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/29/mp4/180629092406999986.mp4\",\n" +
            "            \"videoTitle\": \"邪不压正 终极预告\",\n" +
            "            \"videoLength\": 118,\n" +
            "            \"rating\": 7.1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"剧情\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"姜文彭于晏演绎民国风范\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71056,\n" +
            "            \"movieName\": \"凯奇叔主演惊悚新片《曼蒂》首发预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/28/085127.49713155_120X90X4.jpg\",\n" +
            "            \"movieId\": 249101,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/28/mp4/180628085201616992.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/28/mp4/180628085201616992.mp4\",\n" +
            "            \"videoTitle\": \"首支预告片\",\n" +
            "            \"videoLength\": 150,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"视觉效果挑战观影极限\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71039,\n" +
            "            \"movieName\": \"《铁血战士》中文剧场版预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/26/214927.82061800_120X90X4.jpg\",\n" +
            "            \"movieId\": 227422,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/26/mp4/180626214809040834.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/26/mp4/180626214809040834.mp4\",\n" +
            "            \"videoTitle\": \"铁血战士 中文剧场版预告\",\n" +
            "            \"videoLength\": 140,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"冒险\",\n" +
            "                \"恐怖\",\n" +
            "                \"科幻\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"“铁血”不灭，热血依旧\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71013,\n" +
            "            \"movieName\": \"丹泽尔华盛顿《制裁特攻》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/25/113805.43647289_120X90X4.jpg\",\n" +
            "            \"movieId\": 224018,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/25/mp4/180625113800483950.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/25/mp4/180625113800483950.mp4\",\n" +
            "            \"videoTitle\": \"制裁特攻 预告片2\",\n" +
            "            \"videoLength\": 162,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"犯罪\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"丹泽尔华盛顿怒揭惊天密谋\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71018,\n" +
            "            \"movieName\": \"老年版十二罗汉《大盗之王》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/25/194034.72430321_120X90X4.jpg\",\n" +
            "            \"movieId\": 258538,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/25/mp4/180625194124514758.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/25/mp4/180625194124514758.mp4\",\n" +
            "            \"videoTitle\": \"大盗之王 先导预告片\",\n" +
            "            \"videoLength\": 60,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"剧情\",\n" +
            "                \"犯罪\"\n" +
            "            ],\n" +
            "            \"summary\": \"看老爷子们各个戏精倚老卖老\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71004,\n" +
            "            \"movieName\": \"提奥·詹姆斯《末路》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/24/110037.21711721_120X90X4.jpg\",\n" +
            "            \"movieId\": 258500,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/24/mp4/180624105458082927.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/24/mp4/180624105458082927.mp4\",\n" +
            "            \"videoTitle\": \"末路 预告片\",\n" +
            "            \"videoLength\": 148,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"惊悚\",\n" +
            "                \"冒险\",\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"女婿岳父穿越绝境勇救妻\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70981,\n" +
            "            \"movieName\": \"《狄仁杰之四大天王》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/21/220908.14406942_120X90X4.jpg\",\n" +
            "            \"movieId\": 232758,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/21/mp4/180621220935341411.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/21/mp4/180621220935341411.mp4\",\n" +
            "            \"videoTitle\": \"狄仁杰之四大天王 “天王现身”预告\",\n" +
            "            \"videoLength\": 132,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"悬疑\",\n" +
            "                \"古装\"\n" +
            "            ],\n" +
            "            \"summary\": \"徐克打造\\\"天王移魂案\\\"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 71030,\n" +
            "            \"movieName\": \"韩国谍战片《工作》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/26/175744.17908600_120X90X4.jpg\",\n" +
            "            \"movieId\": 238966,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/26/mp4/180626175900290602.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/26/mp4/180626175900290602.mp4\",\n" +
            "            \"videoTitle\": \"工作 预告片\",\n" +
            "            \"videoLength\": 94,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"剧情\"\n" +
            "            ],\n" +
            "            \"summary\": \"黄政民北京密会朝鲜高层\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70969,\n" +
            "            \"movieName\": \"《欢迎来到马文镇》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/21/095547.44756927_120X90X4.jpg\",\n" +
            "            \"movieId\": 223851,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/21/mp4/180621152714320864.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/21/mp4/180621152714320864.mp4\",\n" +
            "            \"videoTitle\": \"欢迎来到马文镇 剧场版预告片\",\n" +
            "            \"videoLength\": 150,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"剧情\"\n" +
            "            ],\n" +
            "            \"summary\": \"心理创伤男子自救之路\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70968,\n" +
            "            \"movieName\": \"史泰龙《奎迪2》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/20/233235.91430489_120X90X4.jpg\",\n" +
            "            \"movieId\": 231080,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/20/mp4/180620224329461336.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/20/mp4/180620224329461336.mp4\",\n" +
            "            \"videoTitle\": \"奎迪2 预告片\",\n" +
            "            \"videoLength\": 125,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"剧情\",\n" +
            "                \"运动\"\n" +
            "            ],\n" +
            "            \"summary\": \"迈克尔·B·乔丹联手史泰龙\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70959,\n" +
            "            \"movieName\": \"加里·奥德曼《智慧囚屋》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/20/103858.60002242_120X90X4.jpg\",\n" +
            "            \"movieId\": 234059,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/20/mp4/180620152605113056.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/20/mp4/180620152605113056.mp4\",\n" +
            "            \"videoTitle\": \"智慧囚屋 正式预告\",\n" +
            "            \"videoLength\": 108,\n" +
            "            \"rating\": 6,\n" +
            "            \"type\": [\n" +
            "                \"科幻\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"麦卡梦露组团挑战人工智能\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70986,\n" +
            "            \"movieName\": \"\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/22/103225.60035189_120X90X4.jpg\",\n" +
            "            \"movieId\": 258466,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/22/mp4/180622143459428971.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/22/mp4/180622143459428971.mp4\",\n" +
            "            \"videoTitle\": \"致所有我曾爱过的男孩 中文预告片\",\n" +
            "            \"videoLength\": 117,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"爱情\",\n" +
            "                \"剧情\"\n" +
            "            ],\n" +
            "            \"summary\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70941,\n" +
            "            \"movieName\": \"徐峥《我不是药神》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/19/114052.89552287_120X90X4.jpg\",\n" +
            "            \"movieId\": 242167,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/19/mp4/180619114056229996.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/19/mp4/180619114056229996.mp4\",\n" +
            "            \"videoTitle\": \"我不是药神  国际版预告片\",\n" +
            "            \"videoLength\": 90,\n" +
            "            \"rating\": 8.8,\n" +
            "            \"type\": [\n" +
            "                \"剧情\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"“治愈小队”鱼龙混杂 \"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70908,\n" +
            "            \"movieName\": \"姜栋元《人狼》预告片\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/15/140734.44975005_120X90X4.jpg\",\n" +
            "            \"movieId\": 200716,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/15/mp4/180615140855287958.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/15/mp4/180615140855287958.mp4\",\n" +
            "            \"videoTitle\": \"人狼 先导预告片\",\n" +
            "            \"videoLength\": 62,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"姜栋元战甲穿越火线\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70882,\n" +
            "            \"movieName\": \"温子仁监制《鬼修女》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/13/201310.62228225_120X90X4.jpg\",\n" +
            "            \"movieId\": 234983,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/13/mp4/180613201229941112.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/13/mp4/180613201229941112.mp4\",\n" +
            "            \"videoTitle\": \"修女 中文先导预告\",\n" +
            "            \"videoLength\": 90,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"恐怖\",\n" +
            "                \"悬疑\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"\\\"招魂\\\"宇宙衍生片 噩梦来袭\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70878,\n" +
            "            \"movieName\": \"蒂姆波顿《小飞象》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/13/153406.28447279_120X90X4.jpg\",\n" +
            "            \"movieId\": 222039,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/13/mp4/180613153340831472.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/13/mp4/180613153340831472.mp4\",\n" +
            "            \"videoTitle\": \"小飞象 中文先导预告\",\n" +
            "            \"videoLength\": 82,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"家庭\",\n" +
            "                \"奇幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"迪士尼经典动画搬上大银幕\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70833,\n" +
            "            \"movieName\": \"高斯林《登月第一人》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/09/093500.53794377_120X90X4.jpg\",\n" +
            "            \"movieId\": 229976,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/09/mp4/180609183835866592.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/09/mp4/180609183835866592.mp4\",\n" +
            "            \"videoTitle\": \"登月第一人 预告片\",\n" +
            "            \"videoLength\": 152,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"传记\",\n" +
            "                \"剧情\",\n" +
            "                \"历史\"\n" +
            "            ],\n" +
            "            \"summary\": \"宇航员阿姆斯特朗的十年奋斗\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70822,\n" +
            "            \"movieName\": \"《驯龙高手3》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/07/235338.99731887_120X90X4.jpg\",\n" +
            "            \"movieId\": 190574,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/07/mp4/180607235436131884.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/07/mp4/180607235436131884.mp4\",\n" +
            "            \"videoTitle\": \"驯龙高手3 先导中字预告\",\n" +
            "            \"videoLength\": 152,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"动作\",\n" +
            "                \"冒险\",\n" +
            "                \"喜剧\",\n" +
            "                \"家庭\",\n" +
            "                \"奇幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"完结篇没牙仔把妹下功夫\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70823,\n" +
            "            \"movieName\": \"锤哥《皇家酒店谋杀案》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/08/083005.60327014_120X90X4.jpg\",\n" +
            "            \"movieId\": 257745,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/08/mp4/180608084622408958.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/08/mp4/180608084622408958.mp4\",\n" +
            "            \"videoTitle\": \"皇家酒店谋杀案 中文预告\",\n" +
            "            \"videoLength\": 123,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"密室悬疑戏充满诡异\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70820,\n" +
            "            \"movieName\": \"\\\"龙纹身女孩\\\"续集预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/07/213119.98455651_120X90X4.jpg\",\n" +
            "            \"movieId\": 229567,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/07/mp4/180607213158618616.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/07/mp4/180607213158618616.mp4\",\n" +
            "            \"videoTitle\": \"蛛网中的女孩 中文先导预告\",\n" +
            "            \"videoLength\": 96,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"犯罪\",\n" +
            "                \"剧情\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"克莱尔福伊凶悍亮相\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70801,\n" +
            "            \"movieName\": \"动画版《蜘蛛侠》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/06/225052.67474760_120X90X4.jpg\",\n" +
            "            \"movieId\": 228745,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606225204075966.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606225204075966.mp4\",\n" +
            "            \"videoTitle\": \"蜘蛛侠：新纪元 中文预告\",\n" +
            "            \"videoLength\": 144,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"动作\",\n" +
            "                \"家庭\",\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"蜘蛛侠平行宇宙拓展新世界\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70794,\n" +
            "            \"movieName\": \"彼得杰克逊监制《掠食城市》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/06/094742.90338154_120X90X4.jpg\",\n" +
            "            \"movieId\": 237246,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606094810732384.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606094810732384.mp4\",\n" +
            "            \"videoTitle\": \"掠食城市：致命引擎 正式预告\",\n" +
            "            \"videoLength\": 158,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"冒险\",\n" +
            "                \"奇幻\",\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"反乌托邦背景下的移动城市\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70795,\n" +
            "            \"movieName\": \"开心麻花《西虹市首富》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/06/101658.92608147_120X90X4.jpg\",\n" +
            "            \"movieId\": 253688,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606101738263858.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606101738263858.mp4\",\n" +
            "            \"videoTitle\": \"西虹市首富 特笑大片版预告\",\n" +
            "            \"videoLength\": 97,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"一个月花光10亿！有钱人真苦\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70791,\n" +
            "            \"movieName\": \"《乐高大电影2》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/05/223040.81202598_120X90X4.jpg\",\n" +
            "            \"movieId\": 212573,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606102955107576.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/06/mp4/180606102955107576.mp4\",\n" +
            "            \"videoTitle\": \"乐高大电影2 中文版先行预告片\",\n" +
            "            \"videoLength\": 144,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"冒险\",\n" +
            "                \"喜剧\"\n" +
            "            ],\n" +
            "            \"summary\": \"乐高小人贱萌恶搞\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70782,\n" +
            "            \"movieName\": \"《大黄蜂》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/05/150608.66309763_120X90X4.jpg\",\n" +
            "            \"movieId\": 246986,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/05/mp4/180605162435360465.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/05/mp4/180605162435360465.mp4\",\n" +
            "            \"videoTitle\": \"大黄蜂 中文版先行预告片\",\n" +
            "            \"videoLength\": 131,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"冒险\",\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"大黄蜂又帅又萌惹人爱\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70775,\n" +
            "            \"movieName\": \"《无敌破坏王2》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/05/085452.15986240_120X90X4.jpg\",\n" +
            "            \"movieId\": 226450,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/05/mp4/180605085812219040.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/05/mp4/180605085812219040.mp4\",\n" +
            "            \"videoTitle\": \"无敌破坏王2 中文预告片\",\n" +
            "            \"videoLength\": 148,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"冒险\",\n" +
            "                \"喜剧\",\n" +
            "                \"家庭\",\n" +
            "                \"奇幻\",\n" +
            "                \"科幻\"\n" +
            "            ],\n" +
            "            \"summary\": \"迪士尼诸多公主大聚会\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70772,\n" +
            "            \"movieName\": \"《阴风阵阵》先导预告片\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/04/221056.29996439_120X90X4.jpg\",\n" +
            "            \"movieId\": 168207,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/04/mp4/180604221106909161.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/04/mp4/180604221106909161.mp4\",\n" +
            "            \"videoTitle\": \"阴风阵阵 先导预告片\",\n" +
            "            \"videoLength\": 82,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"奇幻\",\n" +
            "                \"恐怖\",\n" +
            "                \"悬疑\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"一部关于女权的恐怖电影\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70773,\n" +
            "            \"movieName\": \"《寡妇特工》中文预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/04/222220.23060500_120X90X4.jpg\",\n" +
            "            \"movieId\": 236877,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/05/mp4/180605095222000709.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/05/mp4/180605095222000709.mp4\",\n" +
            "            \"videoTitle\": \"寡妇特工 中文预告片\",\n" +
            "            \"videoLength\": 137,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"犯罪\",\n" +
            "                \"剧情\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"结合黑人和女权主题\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70759,\n" +
            "            \"movieName\": \"《碟中谍6》高空跳伞特辑\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/03/155600.14311928_120X90X4.jpg\",\n" +
            "            \"movieId\": 226992,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/03/mp4/180603155601659371.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/03/mp4/180603155601659371.mp4\",\n" +
            "            \"videoTitle\": \"碟中谍6：全面瓦解 制作特辑之HALO跳伞\",\n" +
            "            \"videoLength\": 157,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"冒险\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"阿汤哥搏命演出挑战高危动作\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70753,\n" +
            "            \"movieName\": \"张艺谋新片《影》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/06/01/173725.41861836_120X90X4.jpg\",\n" +
            "            \"movieId\": 242119,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/06/01/mp4/180601173732856982.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/06/01/mp4/180601173732856982.mp4\",\n" +
            "            \"videoTitle\": \"影 “当局不迷”版预告片\",\n" +
            "            \"videoLength\": 81,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"剧情\"\n" +
            "            ],\n" +
            "            \"summary\": \"黑白水墨风！邓超孙俪怒目而视\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70735,\n" +
            "            \"movieName\": \"史泰龙黄晓明《金蝉脱壳2》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/05/31/210929.22428677_120X90X4.jpg\",\n" +
            "            \"movieId\": 237446,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/05/31/mp4/180531210935070764.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/05/31/mp4/180531210935070764.mp4\",\n" +
            "            \"videoTitle\": \"金蝉脱壳2 定档预告\",\n" +
            "            \"videoLength\": 102,\n" +
            "            \"rating\": 5,\n" +
            "            \"type\": [\n" +
            "                \"动作\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"summary\": \"中西合璧的动作大戏\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70714,\n" +
            "            \"movieName\": \"日版《那些年》预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/05/30/092602.47482752_120X90X4.jpg\",\n" +
            "            \"movieId\": 251623,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/05/30/mp4/180530092738916376.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/05/30/mp4/180530092738916376.mp4\",\n" +
            "            \"videoTitle\": \"那些年，我们一起追的女孩 先导预告\",\n" +
            "            \"videoLength\": 30,\n" +
            "            \"rating\": 0,\n" +
            "            \"type\": [\n" +
            "                \"爱情\"\n" +
            "            ],\n" +
            "            \"summary\": \"斋藤飞鸟版“沈佳宜”登场\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 70695,\n" +
            "            \"movieName\": \"《挚爱维尼》剧场版预告\",\n" +
            "            \"coverImg\": \"http://img5.mtime.cn/mg/2018/05/27/103501.33563781_120X90X4.jpg\",\n" +
            "            \"movieId\": 254191,\n" +
            "            \"url\": \"http://vfx.mtime.cn/Video/2018/05/27/mp4/180527103240424864.mp4\",\n" +
            "            \"hightUrl\": \"http://vfx.mtime.cn/Video/2018/05/27/mp4/180527103240424864.mp4\",\n" +
            "            \"videoTitle\": \"克里斯托弗·罗宾 台版中字剧场版预告片\",\n" +
            "            \"videoLength\": 149,\n" +
            "            \"rating\": -1,\n" +
            "            \"type\": [\n" +
            "                \"动画\",\n" +
            "                \"冒险\",\n" +
            "                \"喜剧\",\n" +
            "                \"剧情\",\n" +
            "                \"家庭\",\n" +
            "                \"歌舞\"\n" +
            "            ],\n" +
            "            \"summary\": \"迪士尼经典IP 童年故友归来\"\n" +
            "        }\n" +
            "    ]";

    public static String appsJson = "[\n" +
            "    {\n" +
            "        \"appName\": \"ShareMate\",\n" +
            "        \"url\": \"https://github.com/fushenghua/ShareMate\",\n" +
            "        \"desc\": \"Don't Dependencies on other SDKs to share the SDK. It's very simple\",\n" +
            "        \"iconUrl\": \"https://raw.githubusercontent.com/fushenghua/ShareMate/master/app/src/main/res/mipmap-xxhdpi/ic_launcher.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"appName\": \"FastCleaner\",\n" +
            "        \"url\": \"https://github.com/fushenghua/FastCleaner\",\n" +
            "        \"desc\": \"FastCleaner ，SimilarPhoto相似图片清理、垃圾清理、内存加速stuck_out_tongue_closed_eyes\",\n" +
            "        \"iconUrl\": \"https://raw.githubusercontent.com/fushenghua/FastCleaner/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"appName\": \"YouMate\",\n" +
            "        \"url\": \"https://github.com/fushenghua/hexo-theme-apps\",\n" +
            "        \"desc\": \"方便快速,提供的app下载官网页面\",\n" +
            "        \"iconUrl\": \"https://raw.githubusercontent.com/fushenghua/ShareMate/master/app/src/main/res/mipmap-xxhdpi/ic_launcher_round.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"appName\": \"Video-List-Player\",\n" +
            "        \"url\": \"https://github.com/fushenghua/Video-List-Player\",\n" +
            "        \"desc\": \"Play video in ListView or RecyclerView\",\n" +
            "        \"iconUrl\": \"https://raw.githubusercontent.com/fushenghua/Video-List-Player/master/app/src/main/res/mipmap-xxhdpi/ic_launcher.png\"\n" +
            "    }\n" +
            "]";

    public static List<VideoBean> getVideos() {
        return new Gson().fromJson(dataJson, new TypeToken<ArrayList<VideoBean>>() {
        }.getType());
    }

    public static List<FamilyBean> getApps() {
        return new Gson().fromJson(appsJson, new TypeToken<ArrayList<FamilyBean>>() {
        }.getType());
    }

}
