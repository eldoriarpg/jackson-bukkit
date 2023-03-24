/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.legacy;

import de.eldoria.jacksonbukkit.serializer.PotionEffectSerializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LegacyTest {

    @Test
    public void testLegacyPotion() {
        assertTrue(PotionEffectSerializer.LEGACY);
    }

}
