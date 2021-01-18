/**
 * The MIT License
 *
 * Copyright for portions of unirest-java are held by Kong Inc (c) 2013.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package kong.tests;

import kong.unirest.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

class RegistrationTest {

    @Test
    void canRegisterThePrimaryInstance() {
        MockClient client = MockClient.register();
        assertSame(client, Unirest.primaryInstance().config().getClient());
        assertSame(client, Unirest.primaryInstance().config().getClient());

        MockClient.clear();

        assertFalse(Unirest.primaryInstance().config().getClient() instanceof MockClient);
        assertFalse(Unirest.primaryInstance().config().getClient() instanceof MockClient);
    }

    @Test
    void canRegisterInstances() {
        UnirestInstance i = Unirest.spawnInstance();
        MockClient client = MockClient.register(i);
        assertSame(client, i.config().getClient());
        assertSame(client, i.config().getClient());

        MockClient.clear(i);

        assertFalse(i.config().getClient() instanceof MockClient);
        assertFalse(i.config().getClient() instanceof MockClient);
    }
}
