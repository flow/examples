/*
 * This file is part of Flow Plugins Example, licensed under the MIT License (MIT).
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
package com.flowpowered.examples.plugins.annotated;

import com.flowpowered.examples.plugins.engine.ExampleContext;
import com.flowpowered.examples.plugins.engine.UnusedContext;
import com.flowpowered.plugins.Context;
import com.flowpowered.plugins.annotated.Disable;
import com.flowpowered.plugins.annotated.Enable;
import com.flowpowered.plugins.annotated.Plugin;

@Plugin(name = "exampleannotatedplugin")
public class ExampleAnnotatedPlugin {

    @Enable
    public void onEnable(ExampleContext c) {
        System.out.println("Enabled: " + c.getPlugin().getName());
        c.getExample().callFromPlugin();
    }

    @Disable
    public void onDisable(UnusedContext c) {
        throw new IllegalStateException();
    }

    @Disable
    public void onDisable(Context c) {
        System.out.println("Disabled: " + c.getPlugin().getName());
    }
}
