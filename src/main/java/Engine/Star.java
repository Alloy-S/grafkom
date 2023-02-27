package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;

public class Star extends Object2d {
    Vector3f center, radius;

    public Star(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius, float rotate) {
        super(shaderModuleDataList, vertices, color);
        this.center = center;
        this.radius = radius;
        createStar(rotate);
        setupVAOVBO();
    }


    public void createStar(float rotate) {
        //vertices -> clear
        vertices.clear();
        float x, y;

        x = (float) (radius.x * Math.cos(Math.toRadians(0 + rotate)) + center.x);
        y = (float) (radius.y * Math.sin(Math.toRadians(0 + rotate)) + center.y);
        vertices.add(new Vector3f(x, y, 0.0f));

        x = (float) (radius.x * Math.cos(Math.toRadians(144 + rotate)) + center.x);
        y = (float) (radius.y * Math.sin(Math.toRadians(144 + rotate)) + center.y);
        vertices.add(new Vector3f(x, y, 0.0f));

        x = (float) (radius.x * Math.cos(Math.toRadians(288 + rotate)) + center.x);
        y = (float) (radius.y * Math.sin(Math.toRadians(288 + rotate)) + center.y);
        vertices.add(new Vector3f(x, y, 0.0f));

        x = (float) (radius.x * Math.cos(Math.toRadians(72 + rotate)) + center.x);
        y = (float) (radius.y * Math.sin(Math.toRadians(72 + rotate)) + center.y);
        vertices.add(new Vector3f(x, y, 0.0f));

        x = (float) (radius.x * Math.cos(Math.toRadians(216 + rotate)) + center.x);
        y = (float) (radius.y * Math.sin(Math.toRadians(216 + rotate)) + center.y);
        vertices.add(new Vector3f(x, y, 0.0f));
    }

    public void draw() {
        drawSetup();
        // draw the vertices
        glLineWidth(2);
        glPointSize(0);
        glDrawArrays(GL_LINE_LOOP, 0, vertices.size());
    }
}
