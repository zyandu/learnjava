package me.zy.pattern.proxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

public class PayMentDynamicProxy implements InvokeHandler {
    public OutputStream _invoke(String method, InputStream input, ResponseHandler handler) throws SystemException {
        return null;
    }
}
