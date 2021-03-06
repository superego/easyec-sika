package com.googlecode.easyec.sika.mappings.annotations;

import com.googlecode.easyec.sika.converters.ColumnConverter;
import com.googlecode.easyec.sika.converters.NoOpConverter;
import com.googlecode.easyec.sika.validations.ColumnValidator;

import java.lang.annotation.*;

/**
 * 针对于<code>Workbook</code>一行中的某一列的注解类。
 *
 * @author JunJie
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnMapping {

    /**
     * 映射到工作本中的列字母。
     * 该属性定义了从工作本读取或写入工作本的列。
     * 列用根据Excel中定义的字母为准，且字母必须为大写。
     * <p>
     * Max column name in Excel 2003：IV（256）
     * <br/>
     * Max column name in Excel 2007：XFD（16384）
     * </p>
     *
     * @return 列字母
     */
    String column() default "";

    /**
     * 映射到工作本中的列字母。
     * 该属性只用于从工作本中读取时，
     * 定义的要被解析的列。
     * 其规则与{@link #column}一致
     *
     * @return 列字母
     */
    String columnForRead() default "";

    /**
     * 映射到工作本中的列字母。
     * 该属性只用于将字段值写入工作本时，
     * 定义的要被解析的列。
     * 其规则与{@link #column}一致
     *
     * @return 列字母
     */
    String columnForWrite() default "";

    /**
     * 定义实现了接口{@link ColumnValidator}的验证器。
     * <p>
     * 此类只可在解析工作本的时候被调用，
     * 当数据写入工作本时候，
     * 此属性定义的验证器类都将被忽略。
     * </p>
     *
     * @return 返回列验证器的实现类
     * @see ColumnValidator
     */
    Class<? extends ColumnValidator>[] validators() default { };

    /**
     * 定义一个列数据转换器的实现类。该类可以用来在正式为属性赋值前转换其值类型。
     *
     * @return 返回列数据转换器的实现类
     * @see ColumnConverter
     */
    Class<? extends ColumnConverter> converter() default NoOpConverter.class;
}
