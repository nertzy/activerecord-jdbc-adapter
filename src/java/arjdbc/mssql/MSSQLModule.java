/*
 * The MIT License
 *
 * Copyright 2013 Karol Bucek.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package arjdbc.mssql;

import static arjdbc.util.QuotingUtils.BYTES_0;
import static arjdbc.util.QuotingUtils.BYTES_1;
import static arjdbc.util.QuotingUtils.quoteSingleQuotesWithFallback;

import org.jruby.RubyModule;
import org.jruby.RubyString;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * ArJdbc::MSSQL
 * 
 * @author kares
 */
public class MSSQLModule {
    
    public static void load(final RubyModule arJdbc) {
        RubyModule mssql = arJdbc.defineModuleUnder("MSSQL");
        mssql.defineAnnotatedMethods( MSSQLModule.class );
    }
    
    @JRubyMethod(name = "quote_string", required = 1, frame = false)
    public static IRubyObject quote_string(
            final ThreadContext context, 
            final IRubyObject self, 
            final IRubyObject string) {
        return quoteSingleQuotesWithFallback(context, string);
    }
    
    @JRubyMethod(name = "quoted_true", required = 0, frame = false)
    public static IRubyObject quoted_true(
            final ThreadContext context, 
            final IRubyObject self) {
        return RubyString.newString(context.getRuntime(), BYTES_1);
    }
    
    @JRubyMethod(name = "quoted_false", required = 0, frame = false)
    public static IRubyObject quoted_false(
            final ThreadContext context, 
            final IRubyObject self) {
        return RubyString.newString(context.getRuntime(), BYTES_0);
    }
    
}