/*
 * Copyright (c) 2013, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.fge.jsonschema.library.syntax;

import com.github.fge.jsonschema.library.Dictionary;
import com.github.fge.jsonschema.library.MutableDictionary;
import com.github.fge.jsonschema.syntax.PositiveIntegerSyntaxChecker;
import com.github.fge.jsonschema.syntax.SyntaxChecker;
import com.github.fge.jsonschema.syntax.TypeOnlySyntaxChecker;
import com.github.fge.jsonschema.syntax.common.AdditionalItemsSyntaxChecker;
import com.github.fge.jsonschema.syntax.common.ExclusiveMaximumSyntaxChecker;
import com.github.fge.jsonschema.syntax.common.ExclusiveMinimumSyntaxChecker;

import static com.github.fge.jsonschema.util.NodeType.*;

public final class CommonSyntaxCheckerDictionary
{
    private static final Dictionary<SyntaxChecker> DICTIONARY;

    public static Dictionary<SyntaxChecker> get()
    {
        return DICTIONARY;
    }

    private CommonSyntaxCheckerDictionary()
    {
    }

    static {
        final MutableDictionary<SyntaxChecker> dict
            = MutableDictionary.newInstance();

        String keyword;
        SyntaxChecker checker;

        /*
         * Arrays
         */

        keyword = "additionalItems";
        checker = AdditionalItemsSyntaxChecker.getInstance();
        dict.addEntry(keyword, checker);

        keyword = "minItems";
        checker = new PositiveIntegerSyntaxChecker(keyword);
        dict.addEntry(keyword, checker);

        keyword = "maxItems";
        checker = new PositiveIntegerSyntaxChecker(keyword);
        dict.addEntry(keyword, checker);

        keyword = "uniqueItems";
        checker = new TypeOnlySyntaxChecker(keyword, BOOLEAN);
        dict.addEntry(keyword, checker);

        /*
         * Integers and numbers
         */
        keyword = "minimum";
        checker = new TypeOnlySyntaxChecker(keyword, INTEGER, NUMBER);
        dict.addEntry(keyword, checker);

        keyword = "exclusiveMinimum";
        checker = ExclusiveMinimumSyntaxChecker.getInstance();
        dict.addEntry(keyword, checker);

        keyword = "maximum";
        checker = new TypeOnlySyntaxChecker(keyword, INTEGER, NUMBER);
        dict.addEntry(keyword, checker);

        keyword = "exclusiveMaximum";
        checker = ExclusiveMaximumSyntaxChecker.getInstance();
        dict.addEntry(keyword, checker);

        DICTIONARY = dict.freeze();
    }
}