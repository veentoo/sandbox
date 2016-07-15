package org.veentoo.js.converters;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;
import org.mozilla.javascript.NativeObject;

import java.util.ArrayList;
import java.util.List;

public class TestToNativeObjectTransformer {

    private static final Logger log = Logger.getLogger(TestToNativeObjectTransformer.class);

    @Test
    public void testTransformation(){
        // TODO: 7/15/2016
    }

    private static final List<String> responses = new ArrayList<String>() {
        {
            add("--- JUNOS 12.3R1.7 built 2013-01-26 01:33:20 UTC\n" +
                    "\n" +
                    "Hello! It's a shared device.\n" +
                    "Please, use `edit private` instead of `edit` command.\n" +
                    "Thank You!\n" +
                    "\n" +
                    "netconf\n" +
                    "iptest@jm10i> netconf\n" +
                    "<!-- No zombies were killed during the creation of this user interface -->\n" +
                    "<!-- user iptest, class j-super-user -->\n" +
                    "<hello>\n" +
                    "  <capabilities>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:base:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:candidate:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:confirmed-commit:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:validate:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:url:1.0?protocol=http,ftp,file</capability>\n" +
                    "    <capability>http://xml.juniper.net/netconf/junos/1.0</capability>\n" +
                    "    <capability>http://xml.juniper.net/dmi/system/1.0</capability>\n" +
                    "  </capabilities>\n" +
                    "  <session-id>20372</session-id>\n" +
                    "</hello>\n");
            add("<rpc-reply xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\" xmlns:junos=\"http://xml.juniper.net/junos/12.3R1/junos\">\n" +
                    "    <rpc-error>\n" +
                    "        <error-severity>error</error-severity>\n" +
                    "        <error-info>\n" +
                    "            <bad-element>targets</bad-element>\n" +
                    "        </error-info>\n" +
                    "        <error-message>syntax error, expecting &lt;invoke-on&gt;</error-message>\n" +
                    "    </rpc-error>\n" +
                    "    <rpc-error>\n" +
                    "        <error-severity>error</error-severity>\n" +
                    "        <error-info>\n" +
                    "            <bad-element>targets</bad-element>\n" +
                    "        </error-info>\n" +
                    "        <error-message>syntax error</error-message>\n" +
                    "    </rpc-error>\n" +
                    "</rpc-reply>\n" +
                    "]]>]]>");
        }
    };

    private static final List<String> parsedResponses = new ArrayList<String>() {
        {
            add("<hello>\n" +
                    "  <capabilities>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:base:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:candidate:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:confirmed-commit:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:validate:1.0</capability>\n" +
                    "    <capability>urn:ietf:params:xml:ns:netconf:capability:url:1.0?protocol=http,ftp,file</capability>\n" +
                    "    <capability>http://xml.juniper.net/netconf/junos/1.0</capability>\n" +
                    "    <capability>http://xml.juniper.net/dmi/system/1.0</capability>\n" +
                    "  </capabilities>\n" +
                    "  <session-id>20372</session-id>\n" +
                    "</hello>");
            add("<rpc-reply xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\" xmlns:junos=\"http://xml.juniper.net/junos/12.3R1/junos\">\n" +
                    "    <rpc-error>\n" +
                    "        <error-severity>error</error-severity>\n" +
                    "        <error-info>\n" +
                    "            <bad-element>targets</bad-element>\n" +
                    "        </error-info>\n" +
                    "        <error-message>syntax error, expecting &lt;invoke-on&gt;</error-message>\n" +
                    "    </rpc-error>\n" +
                    "    <rpc-error>\n" +
                    "        <error-severity>error</error-severity>\n" +
                    "        <error-info>\n" +
                    "            <bad-element>targets</bad-element>\n" +
                    "        </error-info>\n" +
                    "        <error-message>syntax error</error-message>\n" +
                    "    </rpc-error>\n" +
                    "</rpc-reply>");
        }
    };

}
