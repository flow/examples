/*
 * This file is part of Flow Networking Example, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 Spout LLC <https://spout.org/>
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
package com.flowpowered.examples.networking.message;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import com.flowpowered.networking.Codec;
import com.flowpowered.networking.MessageHandler;

import com.flowpowered.examples.networking.DynamicSession;

public class TestMessageCodec implements Codec<TestMessage>, MessageHandler<DynamicSession, TestMessage> {
    @Override
    public TestMessage decode(ByteBuf buffer) throws IOException {
        return new TestMessage(buffer.readInt());
    }

    @Override
    public ByteBuf encode(ByteBuf buf, TestMessage message) throws IOException {
        buf.writeInt(message.getNumber());
        return buf;
    }

    public void handle(DynamicSession session, TestMessage message) {
        System.out.println("Received TestMessage with number: " + message.getNumber());
    }
}
