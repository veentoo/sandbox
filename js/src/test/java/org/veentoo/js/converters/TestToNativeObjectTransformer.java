package org.veentoo.js.converters;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.ast.StringLiteral;

import java.util.ArrayList;
import java.util.List;

public class TestToNativeObjectTransformer {

    private static final Logger log = Logger.getLogger(TestToNativeObjectTransformer.class);

    @Test
    public void testTransformation(){
        List<String> xmls = new ArrayList<String>() {
            {
                add("<root>\n" +
                    "    <el1>\n" +
                    "        <b>b1</b>\n" +
                    "        <b>b2</b>\n" +
                    "        <b>\n" +
                    "            <c>\n" +
                    "                <d>d1</d>\n" +
                    "            </c>\n" +
                    "        </b>\n" +
                    "    </el1>\n" +
                    "</root>");
                add("<root></root>");
            }
        };

        for (String s : xmls) {
            testTransformString(s);
        }
    }

    private void testTransformString(String xml) {
        log.info("transformin xml: " + xml);
        JSONObject jsonObject = XML.toJSONObject(xml);
        log.info("json: " + jsonObject.toString(4));
        NativeObject transformed = (NativeObject) ToNativeObjectTransformer.getInstance().transformObject(jsonObject);
        log.info("NativeObject: " + transformed.toString());
    }

}
