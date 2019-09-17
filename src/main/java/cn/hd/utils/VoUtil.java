package cn.hd.utils;



import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Administrator on 2016/4/8.
 */
public class VoUtil {

    public static void copyVO2POJO(Object vo, Object pojo) {
        if (vo == null || pojo == null) {
            return;
        }
        try {
            List<FieldDouble> fields = calCommonFields(vo, pojo);
            for (FieldDouble f : fields) {
                f.f2.set(pojo, f.f1.get(vo));
            }
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Map<String, List<FieldDouble>> map = new HashMap<String, List<FieldDouble>>();

    private static List<FieldDouble> calCommonFields(Object vo, Object pojo) {
        Class<?> aClass = vo.getClass();
        Class<?> aClass1 = pojo.getClass();
        String key = aClass.getName() + aClass1.getName();
        List<FieldDouble> ret = map.get(key);
        if (ret != null) {
            return ret;
        }
        List<Field> vfl = calFields(aClass);
        List<Field> pfl = calFields(aClass1);
        ret = con(vfl, pfl);
        map.put(key, ret);
        return ret;
    }

    private static List<FieldDouble> con(List<Field> vfl, List<Field> pfl) {
        List<FieldDouble> ret = new ArrayList<FieldDouble>();
        for (Field v : vfl) {
            for (Field p : pfl) {
                if (equalss(v, p)) {
                    v.setAccessible(true);
                    p.setAccessible(true);
                    ret.add(new FieldDouble(v, p));
                }
            }
        }
        return ret;
    }

    private static boolean equalss(Field v, Field p) {
        return v.getName().equals(p.getName());
    }

    private static List<Field> calFields(Class<? extends Object> a) {
        List<Field> ret = new ArrayList<Field>();
        calFields(a, ret);
        try {
            a = a.getSuperclass();
            calFields(a, ret);
        } catch (Throwable e) {
        }
        try {
            a = (Class) a.getGenericSuperclass();
            calFields(a, ret);
        } catch (Throwable e) {
        }
        return ret;
    }

    private static void calFields(Class<? extends Object> a, List<Field> ret) {
        Field[] fs = a.getDeclaredFields();
        for (Field f : fs) {
            ret.add(f);
        }
        fs = a.getFields();
        for (Field f : fs) {
            ret.add(f);
        }
    }


    public static Object getField(Object o, String field) {
        try {
            Field f = o.getClass().getField(field);
            f.setAccessible(true);
            return f.get(o);
        } catch (Throwable e) {
            try {
                Field f = o.getClass().getDeclaredField(field);
                f.setAccessible(true);
                return f.get(o);
            } catch (Throwable e1) {
                try {
                    Field f = ((Class) o.getClass().getGenericSuperclass()).getDeclaredField(field);
                    f.setAccessible(true);
                    return f.get(o);
                } catch (Throwable e2) {
                    try {
                        Field f = ((Class) o.getClass().getGenericSuperclass()).getField(field);
                        f.setAccessible(true);
                        return f.get(o);
                    } catch (Throwable e3) {
                        try {
                            Field f = ((Class) o.getClass().getSuperclass().getGenericSuperclass()).getDeclaredField(field);
                            f.setAccessible(true);
                            return f.get(o);
                        }catch (Throwable e4) {
                            return null;
                        }
                    }
                }
            }
        }
    }



}

class FieldDouble {
    public FieldDouble(Field f1, Field f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    Field f1;
    Field f2;
}