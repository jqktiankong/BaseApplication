package com.github.lzyzsd.jsbridge;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * author : jiqingke
 * date : 2021/12/21 11:10
 * description :
 */
public class Message {
    private String callbackId;
    private String responseId;
    private String responseData;
    private String data;
    private String handlerName;
    private static final String CALLBACK_ID_STR = "callbackId";
    private static final String RESPONSE_ID_STR = "responseId";
    private static final String RESPONSE_DATA_STR = "responseData";
    private static final String DATA_STR = "data";
    private static final String HANDLER_NAME_STR = "handlerName";

    public Message() {
    }

    public String getResponseId() {
        return this.responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getResponseData() {
        return this.responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHandlerName() {
        return this.handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("callbackId", this.getCallbackId());
            jsonObject.put("data", this.getData());
            jsonObject.put("handlerName", this.getHandlerName());
            jsonObject.put("responseData", this.getResponseData());
            jsonObject.put("responseId", this.getResponseId());
            return jsonObject.toString();
        } catch (JSONException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Message toObject(String jsonStr) {
        Message m = new Message();

        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            m.setHandlerName(jsonObject.has("handlerName") ? jsonObject.getString("handlerName") : null);
            m.setCallbackId(jsonObject.has("callbackId") ? jsonObject.getString("callbackId") : null);
            m.setResponseData(jsonObject.has("responseData") ? jsonObject.getString("responseData") : null);
            m.setResponseId(jsonObject.has("responseId") ? jsonObject.getString("responseId") : null);
            m.setData(jsonObject.has("data") ? jsonObject.getString("data") : null);
            return m;
        } catch (JSONException var3) {
            var3.printStackTrace();
            return m;
        }
    }

    public static List<Message> toArrayList(String jsonStr) {
        ArrayList list = new ArrayList();

        try {
            JSONArray jsonArray = new JSONArray(jsonStr);

            for(int i = 0; i < jsonArray.length(); ++i) {
                Message m = new Message();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                m.setHandlerName(jsonObject.has("handlerName") ? jsonObject.getString("handlerName") : null);
                m.setCallbackId(jsonObject.has("callbackId") ? jsonObject.getString("callbackId") : null);
                m.setResponseData(jsonObject.has("responseData") ? jsonObject.getString("responseData") : null);
                m.setResponseId(jsonObject.has("responseId") ? jsonObject.getString("responseId") : null);
                m.setData(jsonObject.has("data") ? jsonObject.getString("data") : null);
                list.add(m);
            }
        } catch (JSONException var6) {
            var6.printStackTrace();
        }

        return list;
    }
}
