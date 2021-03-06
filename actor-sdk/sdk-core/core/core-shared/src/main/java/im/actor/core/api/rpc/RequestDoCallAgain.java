package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class RequestDoCallAgain extends Request<ResponseVoid> {

    public static final int HEADER = 0xa76;
    public static RequestDoCallAgain fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestDoCallAgain(), data);
    }

    private long callId;
    private ApiUserOutPeer user;

    public RequestDoCallAgain(long callId, @NotNull ApiUserOutPeer user) {
        this.callId = callId;
        this.user = user;
    }

    public RequestDoCallAgain() {

    }

    public long getCallId() {
        return this.callId;
    }

    @NotNull
    public ApiUserOutPeer getUser() {
        return this.user;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.callId = values.getLong(1);
        this.user = values.getObj(2, new ApiUserOutPeer());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.callId);
        if (this.user == null) {
            throw new IOException();
        }
        writer.writeObject(2, this.user);
    }

    @Override
    public String toString() {
        String res = "rpc DoCallAgain{";
        res += "callId=" + this.callId;
        res += ", user=" + this.user;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
