package com.orange.spellchecker;

import java.util.List;
import java.util.Map;

/**
 * Created by rnuka on 10/24/15.
 */
public interface SpellChecker {
    public Map<String, List<String>> spellCheck(String s);
}
