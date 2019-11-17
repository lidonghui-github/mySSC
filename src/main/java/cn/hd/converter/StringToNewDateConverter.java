package cn.hd.converter;


import cn.hd.enums.ErrorCode;
import cn.hd.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToNewDateConverter implements Converter<String, Date> {
    protected static Logger logger = LoggerFactory.getLogger(StringToNewDateConverter.class);

    @Override
    public Date convert(String s) {
        if(StringUtil.isNull(s)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            logger.error("日期:" + s + "格式不正确!");
            throw new RuntimeException(ErrorCode.日期格式不正确.getName());

        }
    }
}