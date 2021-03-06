/**
 * Copyright 2015 Santhosh Kumar Tekuri
 *
 * The JLibs authors license this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package jlibs.xml.xsd.display;

import jlibs.core.graph.Filter;
import jlibs.core.graph.Navigator;
import jlibs.core.graph.Path;
import jlibs.core.graph.visitors.PathReflectionVisitor;
import org.apache.xerces.xs.XSParticle;

/**
 * @author Santhosh Kumar T
 */
public class XSPathDiplayFilter extends PathReflectionVisitor<Object, Boolean> implements Filter<Path>{
    private Navigator navigator;

    public XSPathDiplayFilter(Navigator navigator){
        this.navigator = navigator;
    }

    @Override
    public boolean select(Path path){
        return visit(path);
    }

    protected Boolean getDefault(Object elem){
        return true;
    }

    @SuppressWarnings({"unchecked"})
    protected boolean process(XSParticle particle){
        return navigator.children(particle).length()!=1;
    }
}
