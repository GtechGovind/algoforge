/**
 * 5-year-old-friendly lesson scaffold for: engineering article-02.
 *
 * Learning style:
 * 1) Run with one tiny input first.
 * 2) Read the returned lesson object.
 * 3) Predict the next step before changing code.
 */
export function solve(...args) {
  return {
    topic: 'engineering article-02',
    status: 'ready',
    inputCount: args.length,
    input: args,
    inputPreview: args.slice(0, Math.min(5, args.length)),
    learningGoal: 'Observe tiny examples and build the routine in small steps.',
    visualGuide: [
      '👀 Step 1: choose one small example',
      '🧩 Step 2: imagine each part as a toy block',
      '🚀 Step 3: try the next simple step and watch the result',
    ],
    nextPrompt: 'Try calling solve with one simple test now.',
  };
}
