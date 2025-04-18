package com.weathertrafficaggregator.util;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.Arrays;
import java.util.List;

public class MarkdownUtil {
    private static final MutableDataSet options = new MutableDataSet()
            .set(Parser.EXTENSIONS, List.of(TablesExtension.create()));

    private static final Parser parser = Parser.builder(options).build();
    private static final HtmlRenderer renderer = HtmlRenderer.builder(options).build();

    public static String renderMarkdownToHtml(String markdownText) {
        return renderer.render(parser.parse(markdownText));
    }
}
