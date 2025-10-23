package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private StopEngine mEngine;
    private SpringStopEngine mSpringStopEngine;
    private StopLogicEngine mStopLogicEngine;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.mStopLogicEngine = stopLogicEngine;
        this.mEngine = stopLogicEngine;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String debug(String desc, float time) {
        return this.mEngine.debug(desc, time);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getVelocity(float x) {
        return this.mEngine.getVelocity(x);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void config(float currentPos, float destination, float currentVelocity, float maxTime, float maxAcceleration, float maxVelocity) {
        StopLogicEngine stopLogicEngine = this.mStopLogicEngine;
        this.mEngine = stopLogicEngine;
        stopLogicEngine.config(currentPos, destination, currentVelocity, maxTime, maxAcceleration, maxVelocity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void springConfig(float currentPos, float destination, float currentVelocity, float mass, float stiffness, float damping, float stopThreshold, int boundaryMode) {
        if (this.mSpringStopEngine == null) {
            this.mSpringStopEngine = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.mSpringStopEngine;
        this.mEngine = springStopEngine;
        springStopEngine.springConfig(currentPos, destination, currentVelocity, mass, stiffness, damping, stopThreshold, boundaryMode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float v) {
        return this.mEngine.getInterpolation(v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mEngine.getVelocity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStopped() {
        return this.mEngine.isStopped();
    }
}
