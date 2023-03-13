import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main3 {
    private Window window = new Window(800, 800, "Hello World");
    ArrayList<Sphere> objects = new ArrayList<>();


    private boolean leftBottonMouse = false;

    public void init() {
        window.init();
        GL.createCapabilities();

        // code here
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(1f, 0f, 0f, 1f),
                new Vector3f(0f, 0f, 0f),
                new Vector3f(0.5f, 0.5f, 0.5f)
        ));


    }
    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0f, 0f, 0f, 1.0f);
            GL.createCapabilities();
//            input();

            // code here
            for (Sphere object : objects) {
                object.draw();
            }

//            for (Rectangle object : objectsRectangle) {
//                object.draw();
//            }
//
//            for (Circle object : objectsCircle) {
//                object.draw();
//            }
//
//            for (Star object : objectsStar) {
//                object.draw();
//            }
//
//            for (Persegi object : objectPersegi) {
//                object.draw();
//            }
//
//            for (Triangle object : objectsTriangle) {
//                object.draw();
//            }
//
//            for (Object object : objectsPointControl) {
//                object.drawLine();
//            }


            // restore stage
            glDisableVertexAttribArray(0);
            // poll for window events
            // the key callback above will only be
            //invoked during this call
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        // terminate GLFW and free the error callback

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }


    public static void main(String[] args) {
        new Main3().run();
    }
}

