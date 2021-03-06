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
package com.flowpowered.examples.plugins.engine;


import java.io.IOException;

import com.flowpowered.plugins.Plugin;

public class PluginsExample {
    public static void main(String[] args) throws IOException, Exception {
        Thread.sleep(1000);
        PluginsExample ex = new PluginsExample();
        ExamplePluginManager manager = new ExamplePluginManager(ex);

        Plugin<ExampleContext> plugin = manager.getPlugin("exampleplugin");
        if (plugin == null) {
            System.out.println("exampleplugin is null.");
        } else {
            plugin.enable();
            plugin.disable();
        }


        Plugin<ExampleContext> annotated = manager.getPlugin("exampleannotatedplugin");
        if (annotated == null) {
            System.out.println("exampleannotatedplugin is null.");
        } else {
            annotated.enable();
            annotated.disable();
        }
    }

    public void callFromPlugin() {
        System.out.println("Called from PluginsExample found with ExampleContext");
    }
}
