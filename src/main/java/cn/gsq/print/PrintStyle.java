package cn.gsq.print;

import cn.hutool.core.util.StrUtil;

/**
 * Project : galaxy
 * Class : cn.gsq.print.PrintStyle
 *
 * @author : gsq
 * @date : 2024-01-19 14:06
 * @note : It's not technology, it's art !
 **/
public class PrintStyle {

    /* 根词 */

    public static final String PREFIX = "\033[";   // 前缀

    public static final String RESET = PREFIX + "0m";   // 重置

    public static final String SEPARATOR = ";";   // 分隔符

    public static final String SUFFIX = "m";   // 后缀

    /* 字体色 */

    public static final String COLOUR_WORD_BLACK = "30";

    public static final String COLOUR_WORD_RED = "31";

    public static final String COLOUR_WORD_GREEN = "32";

    public static final String COLOUR_WORD_YELLOW = "33";

    public static final String COLOUR_WORD_BLUE = "34";

    public static final String COLOUR_WORD_PURPLE = "35";

    public static final String COLOUR_WORD_CYAN = "36";

    public static final String COLOUR_WORD_WHITE = "37";

    /* 背景色 */

    public static final String COLOUR_BACKGROUND_BLACK = "40";

    public static final String COLOUR_BACKGROUND_RED = "41";

    public static final String COLOUR_BACKGROUND_GREEN = "42";

    public static final String COLOUR_BACKGROUND_YELLOW = "43";

    public static final String COLOUR_BACKGROUND_BLUE = "44";

    public static final String COLOUR_BACKGROUND_PURPLE = "45";

    public static final String COLOUR_BACKGROUND_CYAN = "46";

    public static final String COLOUR_BACKGROUND_WHITE = "47";

    /* 字体样式 */

    public static final String STYLE_WORD_BOLD = "1";

    public static final String STYLE_WORD_DIM = "2";

    public static final String STYLE_WORD_ITALIC = "3";

    public static final String STYLE_WORD_UNDERLINE = "4";

    public static final String STYLE_WORD_FLICKER = "5";

    public static final String STYLE_WORD_BACK = "7";

    public static final String STYLE_WORD_HIDE = "8";

    /**
     * @Description : 获取样式
     * @Param : [des]
     * @Return : java.lang.String
     * @Author : gsq
     * @Date : 15:38
     * @note : An art cell !
    **/
    public static String getStyle(String ... des) {
        return PREFIX + StrUtil.join(SEPARATOR, des) + SUFFIX;
    }

    /**
     * @Description : 重置样式
     * @Param : []
     * @Return : java.lang.String
     * @Author : gsq
     * @Date : 15:38
     * @note : An art cell !
    **/
    public static String getReset() {
        return RESET;
    }

}
