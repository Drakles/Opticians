package pio.visit;

public class LeansValue {
    private float left;
    private float right;
    public LeansValue(float leftEye, float rightEye) {
        left = leftEye;
        right = rightEye;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "LeansValue{" +
                "left=" + left +
                "L, right=" + right +
                " P}";
    }
}
