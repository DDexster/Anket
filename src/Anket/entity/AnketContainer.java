package Anket.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class AnketContainer {
    private Os os;
    private IDE ide;

    public AnketContainer() {
        this.os = new Os();
        this.ide = new IDE();
    }

    public static void writeContainer(AnketContainer container) {
        Gson gson = new GsonBuilder().create();
        try (PrintWriter writer = new PrintWriter(new FileWriter("/home/ddexster/IdeaProjects/Anket/stats.json"))) {
            writer.print(gson.toJson(container));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AnketContainer getContainer() {
        Gson gson = new GsonBuilder().create();
        String json = parseFile("/home/ddexster/IdeaProjects/Anket/stats.json");
        return gson.fromJson(json, AnketContainer.class);
    }

    private static String parseFile(String path) {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static void initAnket() {
        Gson gson = new GsonBuilder().create();
        AnketContainer container = new AnketContainer();
        try (PrintWriter writer = new PrintWriter(new FileWriter("/home/ddexster/IdeaProjects/Anket/stats.json"))) {
            writer.print(gson.toJson(container));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Os getOs() {
        return os;
    }

    public AnketContainer setOs(Os os) {
        this.os = os;
        return this;
    }

    public IDE getIde() {
        return ide;
    }

    public AnketContainer setIde(IDE ide) {
        this.ide = ide;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AnketContainer{");
        sb.append("os=").append(os);
        sb.append(", ide=").append(ide);
        sb.append('}');
        return sb.toString();
    }
}
