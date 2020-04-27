/*
 * Copyright (C) 2018. OpenLattice, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact the owner of the copyright at support@openlattice.com
 *
 *
 */

package com.openlattice.launchpad.configuration;

import com.openlattice.launchpad.AbstractJacksonSerializationTest;
import org.junit.Assert;

import java.io.IOException;

/**
 * @author Matthew Tamayo-Rios &lt;matthew@openlattice.com&gt;
 */
public class IntegrationSerdesTests extends AbstractJacksonSerializationTest<Integration> {
    @Override protected Integration getSampleData() {
        try {
            return IntegrationConfigurationTests.readIntegrationConfiguration().getIntegrations().values().iterator()
                    .next().values().iterator().next();
        } catch ( IOException e ) {
            e.printStackTrace();
            Assert.fail("IOException getting sample data ");
            return null;
        }
    }

    @Override protected Class<Integration> getClazz() {
        return Integration.class;
    }
}
