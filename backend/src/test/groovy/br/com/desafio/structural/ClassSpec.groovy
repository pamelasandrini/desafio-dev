package br.com.desafio.structural

import spock.lang.Unroll

class ClassSpec {

    @Unroll
    def "Verificar a existencia de classes spec: #folder"() {
        setup:
        List<Class> classes = getClassesInDirectory("${source}${main}${folder}")

        expect:
        boolean isCovered = true
        classes.stream()
            .filter { clazz -> clazz.properties.get("interface") == false }
            .filter { clazz -> clazz.properties.get("enum") == false }
            .filter { clazz -> clazz.getMethods().size() > 9 }
            .forEach { clazz ->
                String java = "${source}${main}${clazz.name.replaceAll("\\.", "/")}.java"
                assert fileExists(java)
                assert clazz.properties.get("interface") == false

                String groovy = "${source}${test}${clazz.name.replaceAll("\\.", "/")}${prefix}"
                if (!java.contains("/entities/") && !fileExists(groovy)) {
                    println java
                    println groovy
                    println ""
                    isCovered = false
                }

            }
        assert isCovered

        where:
        source   | main         | test           | folder            | prefix
        "./src/" | "main/java/" | "test/groovy/" | "br/com/desafio/" | "Spec.groovy"

    }

    @Unroll
    def "Verificar annotation em classes spec: #path with #total founds"() {

        given: "uma lista de todos as classes que estão anotadas"
        List<String> map = getFileWithAnnotations(annotations as String[], path, path, extension)

        expect: "que a quantidade seja validada com o total permitido"
        map.size() == total

        where:
        path                        | extension | annotations                       | total
        "./src/test/groovy/"        | ".groovy" | ["@Ignore", "@spock.lang.Ignore"] | 0
        "./src/integration/groovy/" | ".groovy" | ["@Ignore", "@spock.lang.Ignore"] | 0
        "./src/component/groovy/"   | ".groovy" | ["@Ignore", "@spock.lang.Ignore"] | 0
    }

    private static List<String> getFileWithAnnotations(final String[] annotation, final String path, final String ignorePath, final String extension) {
        final File[] files = new File(path).listFiles()
        final List<String> list = new ArrayList<>()
        for (File file : files) {
            if (file.isDirectory()) {
                list.addAll(getFileWithAnnotations(annotation, file.getPath(), ignorePath, extension))
            } else {
                if (find(file, annotation)) {
                    String className = file.getPath()
                        .replace(ignorePath, "")
                        .replace(extension, "")
                        .replaceAll("/", ".")
                    list.add(className)
                }
            }
        }
        return list
    }

    private static boolean find(File f, String[] searchStrings) {
        try {
            Scanner scanner = new Scanner(f)
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine()
                if (Arrays.asList(searchStrings).stream().anyMatch({ value ->
                    line.trim().indexOf(value.trim()) == 0
                })) {
                    return true
                }
            }
        } catch (Exception e) {
            return false
        }
        return false
    }
}
