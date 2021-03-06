package com.googlecode.easyec.sika.mappings;

import com.googlecode.easyec.sika.*;

import java.util.List;

/**
 * DOCUMENT IT
 *
 * @author JunJie
 */
public class AnnotationWorkbookRowCallback<T> extends WorkbookRowCallback<T> {

    public AnnotationWorkbookRowCallback(Grabber<T> grabber) {
        super(grabber);
    }

    public AnnotationWorkbookRowCallback(WorkbookHeader header, Grabber<T> grabber) {
        super(header, grabber);
    }

    public List<WorkData> populate(int index, T o) throws WorkingException {
        return ColumnEvaluatorFactory.fromBean(index, o, getStrategy());
    }
}
