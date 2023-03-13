import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main2 {
    private Window window = new Window(800, 800, "Hello World");
    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();
    ArrayList<Circle> objectsCircle = new ArrayList<>();
    ArrayList<Star> objectsStar = new ArrayList<>();
    ArrayList<Persegi> objectPersegi = new ArrayList<>();
    ArrayList<Triangle> objectsTriangle = new ArrayList<>();
    ArrayList<Object> objectsPointControl = new ArrayList<>();

    private boolean leftBottonMouse = false;
    private boolean edit = false;
    private int result;

    public void init() {
        window.init();
        GL.createCapabilities();

        // code here
//        objects.add(new Object2d(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of(
//                        new Vector3f(0.0f, 0.5f, 0.0f),
//                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                        new Vector3f(0.5f, -0.5f, 0.0f)
//                )
//        ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f, 0.0f, 0.0f),
//                                new Vector3f(0.0f, 1.0f, 0.0f),
//                                new Vector3f(0.0f, 0.0f, 1.0f)
//                        )
//                )
//        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-1.0f, -0.5f, 0.0f),
                        new Vector3f(1.0f, -0.5f, 0.0f),
                        new Vector3f(-1.0f, -1.0f, 0.0f),
                        new Vector3f(1.0f, -1.0f, 0.0f)
                )
        ),
                new Vector4f(0.279f, 0.490f, 0.290f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-1.0f, 1.0f, 0.0f),
                        new Vector3f(1.0f, 1.0f, 0.0f),
                        new Vector3f(-1.0f, -0.5f, 0.0f),
                        new Vector3f(1.0f, -0.5f, 0.0f)
                )
        ),
                new Vector4f(0.407f, 0.464f, 0.690f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));


//        atap belakang
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.6f, 0.3f, 0.0f),
                        new Vector3f(0.0f, 0.3f, 0.0f),
                        new Vector3f(-0.8f, -0.2f, 0.0f),
                        new Vector3f(0.4f, -0.2f, 0.0f)
                )
        ),
                new Vector4f(0.610f, 0.189f, 0.0610f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));


        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.56f, 0.25f, 0.0f),
                        new Vector3f(0.0f, 0.2f, 0.0f),
                        new Vector3f(-0.7f, -0.1f, 0.0f),
                        new Vector3f(0.0f, -0.1f, 0.0f)
                )
        ),
                new Vector4f(0.710f, 0.514f, 0.454f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

//        tembok
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.7f, -0.1f, 0.0f),
                        new Vector3f(0.7f, -0.1f, 0.0f),
                        new Vector3f(-0.7f, -0.6f, 0.0f),
                        new Vector3f(0.7f, -0.6f, 0.0f)
                )
        ),
                new Vector4f(0.710f, 0.514f, 0.454f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

//        atap depan
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.6f, 0.3f, 0.0f),
                        new Vector3f(0.6f, 0.3f, 0.0f),
                        new Vector3f(-0.4f, -0.2f, 0.0f),
                        new Vector3f(0.8f, -0.2f, 0.0f)
                )
        ),
                new Vector4f(0.610f, 0.189f, 0.0610f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                new Vector3f(-0.7f, 0.7f, 0.0f),
                new Vector3f(0.1f, 0.1f, 0.0f)
        ));

        //bulan
        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 1.0f, 0.5f, 1.0f),
                new Vector3f(-0.7f, 0.7f, 0.0f),
                new Vector3f(0.1f, 0.1f, 0.0f)
        ));

        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.407f, 0.464f, 0.690f, 1.0f),
                new Vector3f(-0.65f, 0.7f, 0.0f),
                new Vector3f(0.1f, 0.1f, 0.0f)
        ));

//        Asap
        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.610f, 0.616f, 0.616f, 1.0f),
                new Vector3f(0.43f, 0.44f, 0.0f),
                new Vector3f(0.07f, 0.04f, 0.0f)
        ));

        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.610f, 0.616f, 0.616f, 1.0f),
                new Vector3f(0.49f, 0.47f, 0.0f),
                new Vector3f(0.1f, 0.05f, 0.0f)
        ));

        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.610f, 0.616f, 0.616f, 1.0f),
                new Vector3f(0.57f, 0.51f, 0.0f),
                new Vector3f(0.13f, 0.05f, 0.0f)
        ));

//        cerobong
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                        new Vector3f(0.39f, 0.35f, 0.0f),
                        new Vector3f(0.48f, 0.35f, 0.0f),
                        new Vector3f(0.39f, 0.2f, 0.0f),
                        new Vector3f(0.48f, 0.2f, 0.0f)
                )
        ),
                new Vector4f(0.710f, 0.514f, 0.454f, 1.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));

//        star
        objectsStar.add(new Star(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 1.0f, 0.5f, 1.0f),
                new Vector3f(0.7f, 0.7f, 0.0f),
                new Vector3f(0.05f, 0.05f, 0.0f),
                30.0f
        ));

        objectsStar.add(new Star(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 1.0f, 0.5f, 1.0f),
                new Vector3f(0.15f, 0.75f, 0.0f),
                new Vector3f(0.03f, 0.03f, 0.0f),
                30.0f
        ));

        objectsStar.add(new Star(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 1.0f, 0.5f, 1.0f),
                new Vector3f(-0.2f, 0.5f, 0.0f),
                new Vector3f(0.05f, 0.05f, 0.0f),
                30.0f
        ));

        objectsPointControl.add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.610f, 0.189f, 0.0610f, 1.0f)
        ));

        objectsPointControl.add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f)
        ));

//        persegi menggunakan lingkaran
//        objectPersegi.add(new Persegi(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));

//        segitiga menggunakan lingkaran
//        objectsTriangle.add(new Triangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),
//                new Vector3f(0.2f, 0.2f, 0.0f)
//        ));


//        //cerobong atas
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of(
//                        new Vector3f(0.37f, 0.35f, 0.0f),
//                        new Vector3f(0.5f, 0.35f, 0.0f),
//                        new Vector3f(0.37f, 0.38f, 0.0f),
//                        new Vector3f(0.5f, 0.38f, 0.0f)
//                )
//        ),
//                new Vector4f(0.610f, 0.189f, 0.0610f, 1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));


//        bintang


    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            System.out.println("W");
        }

        if (window.getMouseInput().isLeftButtonPressed()) {

            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1)) && !leftBottonMouse) {
                if (!edit) {
                    result = checkCollision(objectsPointControl.get(0), pos);
                    if (result == -1) {

                        leftBottonMouse = true;
                        System.out.println("x: " + pos.x + " y: " + pos.y);
//                garis
                        objectsPointControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                persegi
                        objectPersegi.add(new Persegi(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                                ), new ArrayList<>(
                                List.of()
                        ),
                                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                                new Vector3f(pos.x, pos.y, 0.0f),
                                new Vector3f(0.1f, 0.1f, 0.00f)
                        ));

                        curve(objectsPointControl.get(0), objectsPointControl.get(1));

                    } else {
                        edit = true;
                    }
                } else {
//                    System.out.println(result);
//                    System.out.println("edit mode");
//                    if (checkCollision(objectsPointControl.get(0), pos) == -1) {
                        objectPersegi.get(result).update(new Vector3f(pos.x, pos.y, 0.0f));
                        objectsPointControl.get(0).update(result, new Vector3f(pos.x, pos.y, 0.0f));
                        curve(objectsPointControl.get(0), objectsPointControl.get(1));
//                    }
//                    objectsPointControl.get(0).getVertices().set(result, );
                }
            }

        }

        if (window.getMouseInput().isLeftButtonRelease()) {
            leftBottonMouse = false;
            edit = false;
            result = -1;
        }
    }

    public int checkCollision(Object object2d, Vector2f newPos) {
        for (int i = 0; i < object2d.getVerticesSize(); i++) {
            Vector3f pos = object2d.getPos(i);
            float jarak = (float) Math.sqrt((Math.pow(newPos.x - pos.x, 2) + (Math.pow(newPos.y - pos.y, 2))));
            if (jarak < 0.17) {
                return i;
            }
        }
        return -1;
    }

    public void curve(Object object2d, Object newObjects) {
        float x, y;
        newObjects.getVertices().clear();
        int n = object2d.getVerticesSize() - 1;
        for (float t = 0; t <= 1; t += 0.01) {
            x = 0;
            y = 0;
            int count = object2d.getVerticesSize() - 1;

            for (int i = 0; i < object2d.getVerticesSize(); i++) {
                Vector3f pos = object2d.getPos(i);
                float z = (float) (Math.pow((1 - t), count) * Math.pow(t, i)) * combi(n,i);
                x += (z * pos.x);
                y += (z * pos.y);
                count--;
            }
            newObjects.addVertices(new Vector3f(x, y, 0.0f));
        }
    }

    public int combi(int n, int r) {
        return faktorial(n) / (faktorial(n - r) * faktorial(r));
    }

    public int faktorial(int angka)
    {
        if (angka == 0 || angka == 1) {
            return 1;
        } else {
            return angka * faktorial(angka - 1);
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.407f, 0.464f, 0.690f, 1.0f);
            GL.createCapabilities();
            input();

            // code here
            for (Object object : objects) {
                object.draw();
            }

            for (Rectangle object : objectsRectangle) {
                object.draw();
            }

            for (Circle object : objectsCircle) {
                object.draw();
            }

            for (Star object : objectsStar) {
                object.draw();
            }

            for (Persegi object : objectPersegi) {
                object.draw();
            }

            for (Triangle object : objectsTriangle) {
                object.draw();
            }

            for (Object object : objectsPointControl) {
                object.drawLine();
            }


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
        new Main2().run();
    }
}
