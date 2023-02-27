package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;

public class Circle extends Object2d{
    Vector3f center, radius;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color);
        this.center = center;
        this.radius = radius;

        createCircle();
        setupVAOVBO();
    }

    public void createCircle() {
        //vertices -> clear
        vertices.clear();
        for (float angle = 0; angle < 360; angle += 0.1) {
            float x = (float) (radius.x * Math.cos(Math.toRadians(angle)) + center.x);
            float y = (float) (radius.y * Math.sin(Math.toRadians(angle)) + center.y);
            vertices.add(new Vector3f(x, y, 0.0f));

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
