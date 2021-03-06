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

public class ResponseStickersReponse extends Response {

    public static final int HEADER = 0xf0;
    public static ResponseStickersReponse fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseStickersReponse(), data);
    }

    private List<ApiStickerCollection> collections;
    private int seq;
    private byte[] state;

    public ResponseStickersReponse(@NotNull List<ApiStickerCollection> collections, int seq, @NotNull byte[] state) {
        this.collections = collections;
        this.seq = seq;
        this.state = state;
    }

    public ResponseStickersReponse() {

    }

    @NotNull
    public List<ApiStickerCollection> getCollections() {
        return this.collections;
    }

    public int getSeq() {
        return this.seq;
    }

    @NotNull
    public byte[] getState() {
        return this.state;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiStickerCollection> _collections = new ArrayList<ApiStickerCollection>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _collections.add(new ApiStickerCollection());
        }
        this.collections = values.getRepeatedObj(1, _collections);
        this.seq = values.getInt(2);
        this.state = values.getBytes(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.collections);
        writer.writeInt(2, this.seq);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeBytes(3, this.state);
    }

    @Override
    public String toString() {
        String res = "response StickersReponse{";
        res += "collections=" + this.collections;
        res += ", seq=" + this.seq;
        res += ", state=" + byteArrayToString(this.state);
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
