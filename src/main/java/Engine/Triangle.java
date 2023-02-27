package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;

public class Triangle extends Object2d {
    Vector3f center, radius;

    public Triangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color);
        this.center = center;
        this.radius = radius;
        createTriangle();
        setupVAOVBO();
    }

    public void createTriangle() {
        //vertices -> clear
        vertices.clear();
        float angle = 90f;
        for (float i = 0; i < 3; i++) {

            float x = (float) (radius.x * Math.cos(Math.toRadians(angle)) + center.x);
            float y = (float) (radius.y * Math.sin(Math.toRadians(angle)) + center.y);
            vertices.add(new Vector3f(x, y, 0.0f));
            angle += 120;
            if (angle > 360) {
                angle -= 360;
            }

        }

    }
    public void draw() {
        drawSetup();
        // draw the vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }
}
