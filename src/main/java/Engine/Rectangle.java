package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Rectangle extends Object2d{

    List<Integer> index;
    int ibo;


    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;

        this.ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void draw() {
        drawSetup();
        // draw the vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
    }
}