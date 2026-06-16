public class Dynamic_programming_article_02 {
    /**
     * 5-year-old-friendly lesson scaffold for: dynamic programming article-02.
     *
     * Learning style:
     * 1) Run with one tiny input first.
     * 2) Read the returned lesson object.
     * 3) Predict the next step before changing code.
     */
    public Object solve(Object... args) {
        java.util.Map<String, Object> lesson = new java.util.LinkedHashMap<>();
        lesson.put("topic", "dynamic programming article-02");
        lesson.put("status", "ready");
        lesson.put("inputCount", args == null ? 0 : args.length);
        lesson.put("inputPreview", args == null ? "[]" : java.util.Arrays.toString(java.util.Arrays.copyOf(args, Math.min(args.length, 5))));
        lesson.put("learningGoal", "Observe tiny examples and build the routine in small steps.");
        lesson.put("visualGuide", java.util.Arrays.asList(
            "👀 Step 1: choose one small example",
            "🧩 Step 2: imagine each part as a toy block",
            "🚀 Step 3: try the next simple step and watch the result"
        ));
        lesson.put("nextPrompt", "Try calling solve with one simple test now.");
        return lesson;
    }
}
