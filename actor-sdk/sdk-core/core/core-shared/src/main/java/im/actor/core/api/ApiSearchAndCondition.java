package im.actor.core.api;
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

public class ApiSearchAndCondition extends ApiSearchCondition {

    private List<ApiSearchCondition> andQuery;

    public ApiSearchAndCondition(@NotNull List<ApiSearchCondition> andQuery) {
        this.andQuery = andQuery;
    }

    public ApiSearchAndCondition() {

    }

    public int getHeader() {
        return 3;
    }

    @NotNull
    public List<ApiSearchCondition> getAndQuery() {
        return this.andQuery;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.andQuery = new ArrayList<ApiSearchCondition>();
        for (byte[] b : values.getRepeatedBytes(1)) {
            andQuery.add(ApiSearchCondition.fromBytes(b));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        for (ApiSearchCondition i : this.andQuery) {
            writer.writeBytes(1, i.buildContainer());
        }
    }

    @Override
    public String toString() {
        String res = "struct SearchAndCondition{";
        res += "andQuery=" + this.andQuery;
        res += "}";
        return res;
    }

}
