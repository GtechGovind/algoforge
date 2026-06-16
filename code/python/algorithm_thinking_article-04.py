"""5-year-old-friendly lesson scaffold for: algorithm thinking article-04."""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson with tiny examples and return a learning trace."""
    visible = list(args)[:5]
    return {
        "topic": "algorithm thinking article-04",
        "status": "ready",
        "input_count": len(args),
        "input": list(args),
        "input_preview": visible,
        "learning_goal": "Observe tiny examples and build the routine in small steps.",
        "visual_guide": [
            "👀 Step 1: choose one small example",
            "🧩 Step 2: imagine each part as a toy block",
            "🚀 Step 3: try the next simple step and watch the result",
        ],
        "next_prompt": "Try calling solve with one simple test now.",
    }
