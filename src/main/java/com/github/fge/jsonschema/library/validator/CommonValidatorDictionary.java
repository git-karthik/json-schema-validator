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

package com.github.fge.jsonschema.library.validator;

import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.AdditionalItemsKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.AdditionalPropertiesKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaxItemsKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaximumKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinItemsKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinimumKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.UniqueItemKeywordValidator;
import com.github.fge.jsonschema.library.Dictionary;
import com.github.fge.jsonschema.library.DictionaryBuilder;

public final class CommonValidatorDictionary
{
    private static final Dictionary<Class<? extends KeywordValidator>> DICTIONARY;

    private CommonValidatorDictionary()
    {
    }

    public static Dictionary<Class<? extends KeywordValidator>> get()
    {
        return DICTIONARY;
    }

    static {
        final DictionaryBuilder<Class<? extends KeywordValidator>> builder
            = Dictionary.newBuilder();

        String keyword;
        Class<? extends KeywordValidator> descriptor;

        /*
         * Arrays
         */
        keyword = "additionalItems";
        descriptor = AdditionalItemsKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        keyword = "minItems";
        descriptor = MinItemsKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        keyword = "maxItems";
        descriptor = MaxItemsKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        keyword = "uniqueItems";
        descriptor = UniqueItemKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        /*
         * Numbers and integers
         */
        keyword = "minimum";
        descriptor = MinimumKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        keyword = "maximum";
        descriptor = MaximumKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        /*
         * Objects
         */
        keyword = "additionalProperties";
        descriptor = AdditionalPropertiesKeywordValidator.class;
        builder.addEntry(keyword, descriptor);

        DICTIONARY = builder.freeze();
    }
}
