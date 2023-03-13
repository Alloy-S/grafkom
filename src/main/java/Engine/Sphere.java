package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere extends Circle{

    List<Integer> index;
    int ibo;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color, center, radius);
//        createBox();
//        createSphere();
//        createEllipsoid();
//        createHyperboloid1();
//        createHyperboloid2();
        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperboloidParaboloid();
        setupVAOVBO();

    }

    public void createBox(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
//        titik 1 kiri atas belakang
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 2 kiri bawah belakang
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 3 kanan bawah belakang
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 4 kanan atas belakang
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();


        //        titik 5 kiri atas depan
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();


        //        titik 6 kiri bawah depan
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 7 kanan bawah depan
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 8 kanan atas depan
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
//        clc v3
        temp = new Vector3f();


//    kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        //    kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        //    kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        //    kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        //    kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        //    kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(0));
    }
//    end box

    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = 0.5f * (float)Math.cos(stackAngle);
            z = 0.5f * (float)Math.sin(stackAngle);
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = xy * (float)Math.cos(sectorAngle);
                y = xy * (float)Math.sin(sectorAngle);
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }

        this.index = temp_indices;

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createEllipsoid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();


        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }


        vertices = temp;
    }

    public void createHyperboloid1(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * 1/Math.cos(v) * Math.cos(u));
                float z = (float) (0.5f * 1/Math.cos(v) * Math.sin(u));
                float y = (float) (0.5f * Math.tan(v));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }

    public void createHyperboloid2(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * Math.tan(v) * Math.cos(u));
                float z = (float) (0.5f * Math.tan(v) * Math.sin(u));
                float y = (float) (0.5f * 1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }

            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (-0.5f * Math.tan(v) * Math.cos(u));
                float z = (float) (-0.5f * Math.tan(v) * Math.sin(u));
                float y = (float) (-0.5f * 1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }

    public void createEllipticCone(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.cos(u));
                float z = (float) (0.5f * v * Math.sin(u));
                float y = (float) (0.5f * v);
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }

    public void createEllipticParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 100; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f *v * Math.cos(u));
                float z = (float) (0.5f * v * Math.sin(u));
                float y = (float) (Math.pow(v, 2));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }

    public void createHyperboloidParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 100; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float z = (float) (0.5f * v * Math.tan(u));
                float y = (float) (0.5f * v * 1/Math.cos(u));
                float x = (float) (Math.pow(v, 2));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }

    public void draw() {
        drawSetup();
        // draw the vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}