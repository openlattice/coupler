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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Matthew Tamayo-Rios &lt;matthew@openlattice.com&gt;
 */
public class Integration {
    private static final String NAME        = "name";
    private static final String SOURCE      = "source";
    private static final String DESTINATION = "destination";

    private final String               name;
    private final LaunchpadDatasource  source;
    private final LaunchpadDestination destination;

    @JsonCreator
    public Integration(
            @JsonProperty( NAME ) Optional<String> name,
            @JsonProperty( SOURCE ) LaunchpadDatasource source,
            @JsonProperty( DESTINATION ) LaunchpadDestination destination ) {
        this.name = name.orElse( "Unnamed Integration" );
        this.source = source;
        this.destination = destination;
    }

    @JsonProperty( NAME )
    public String getName() {
        return name;
    }

    @JsonProperty( SOURCE )
    public LaunchpadDatasource getSource() {
        return source;
    }

    @JsonProperty( DESTINATION )
    public LaunchpadDestination getDestination() {
        return destination;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o ) { return true; }
        if ( !( o instanceof Integration ) ) { return false; }
        Integration that = (Integration) o;
        return Objects.equals( name, that.name ) &&
                Objects.equals( source, that.source ) &&
                Objects.equals( destination, that.destination );
    }

    @Override public int hashCode() {

        return Objects.hash( name, source, destination );
    }

    @Override public String toString() {
        return "Integration{" +
                "name='" + name + '\'' +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}
