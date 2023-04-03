package fr;

public class BlockText {

    public static void main(String[] args) {
        String blockText = """
                    <html>
                        <body>
                            <h1>Hello, world!</h1>
                        </body>
                    </html>
                """;
        String text = "    <html>\n" +
                "        <body>\n" +
                "            <h1>Hello, world!</h1>\n" +
                "        </body>\n" +
                "    </html>";
        System.out.println(blockText);
        System.out.println(text);
    }
}
