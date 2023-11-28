package com.example.hoang.Utils;

import java.io.*;
import java.util.*;

class Node {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    String id;
    String name;
    List<Node> children;

    String parentID;

    public Node(String id, String name ,String parentID) {
        this.id = id;
        this.name = name;
        this.parentID = parentID;
        this.children = new ArrayList<>();
    }
    public Node() {
    }
}

public class Test {
    public static void main(String[] args) throws IOException {

        List<Node> dataNode1 = new ArrayList<>();
        List<Node> dataNode2 = new ArrayList<>();
        List<Node> dataNode3 = new ArrayList<>();

        String PathData1 = "C:\\Users\\ad\\Desktop\\hoanproject spting boot\\Personal_Project\\WEB-SPRING-BOOT-SALE\\hoang\\src\\main\\java\\com\\example\\hoang\\Utils\\data1.csv";
        String PathData2 = "C:\\Users\\ad\\Desktop\\hoanproject spting boot\\Personal_Project\\WEB-SPRING-BOOT-SALE\\hoang\\src\\main\\java\\com\\example\\hoang\\Utils\\data2.csv";
        String PathData3 = "C:\\Users\\ad\\Desktop\\hoanproject spting boot\\Personal_Project\\WEB-SPRING-BOOT-SALE\\hoang\\src\\main\\java\\com\\example\\hoang\\Utils\\data3.csv";

        dataNode1 =  readCSVFile(PathData1);
        dataNode2 =  readCSVFile(PathData2);
        dataNode3 =  readCSVFile(PathData3);

        System.out.println(dataNode1);
        System.out.println("-----");
        System.out.println(dataNode2);
        System.out.println("-----");
        System.out.println(dataNode3);

        Node root = new Node();
        for (Node node : dataNode1){
            if(node.getParentID().isEmpty()){
                root = node;
            }
        }


        List<Node> chilroot = root.getChildren();
        for (Node node : dataNode1){
            if(node.getParentID().equals(root.getId())){
                chilroot.add(node);
            }
        }
        root.setChildren(chilroot);





    }

    public static List<Node> readCSVFile(String filePath) throws IOException {
        List<Node> nodeL = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator
                if(employee.length == 2 ){
                    Node node = new Node(employee[0],employee[1],"" );
                    if(!node.getId().equals("Id")){
                        nodeL.add(node);
                    }
                    //System.out.println("Employee [Id=" + employee[0] + ", Name=" + employee[1]  + ", ParentID=" + "none"  +"]");
                } else{
                    Node node = new Node(employee[0],employee[1],employee[2] );
                    if(!node.getId().equals("Id")){
                        nodeL.add(node);
                    }
                    //System.out.println("Employee [Id=" + employee[0] + ", Name=" + employee[1]  + ", ParentID=" + employee[2]  +"]");
                }

            }
            return  nodeL;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return  null;
    }

    private static Node buildHierarchy(List<Node> nodes) {
        Map<String, Node> nodeMap = new HashMap<>();

        for (Node node : nodes) {
            nodeMap.put(node.id, node);
        }

        Node root = null;

        for (Node node : nodes) {
            if (nodeMap.containsKey(node.id)) {
                Node parent = nodeMap.get(node.id);

                if (!node.id.equals(node.name)) {
                    parent.name = node.name;
                }

                if (!node.id.equals(node.name) || node.id.isEmpty()) {
                    root = parent;
                }

                for (Node child : node.children) {
                    parent.children.add(child);
                }
            }
        }

        return root;
    }

}




//    private static List<Node> readCsvFile(String filePath) throws IOException {
//        List<Node> nodes = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            String[] parts = line.split(",");
//            String id = parts[0].trim();
//            String name = parts[1].trim();
//            String parentId = parts[2].trim();
//
//            Node node = new Node(id, name);
//            nodes.add(node);
//
//            if (!parentId.isEmpty()) {
//                // Find parent and add current node as a child
//                for (Node parent : nodes) {
//                    if (parent.id.equals(parentId)) {
//                        parent.children.add(node);
//                        break;
//                    }
//                }
//            }
//        }
//
//        reader.close();
//        return nodes;
//    }
//
//    private static Node buildHierarchy(List<Node> nodes) {
//        Map<String, Node> nodeMap = new HashMap<>();
//
//        for (Node node : nodes) {
//            nodeMap.put(node.id, node);
//        }
//
//        Node root = null;
//
//        for (Node node : nodes) {
//            if (nodeMap.containsKey(node.id)) {
//                Node parent = nodeMap.get(node.id);
//
//                if (!node.id.equals(node.name)) {
//                    parent.name = node.name;
//                }
//
//                if (!node.id.equals(node.name) || node.id.isEmpty()) {
//                    root = parent;
//                }
//
//                for (Node child : node.children) {
//                    parent.children.add(child);
//                }
//            }
//        }
//
//        return root;
//    }
//
//    private static void displayHierarchy(Node node, int depth) {
//        if (node != null) {
//            StringBuilder indentation = new StringBuilder();
//            for (int i = 0; i < depth; i++) {
//                indentation.append(" ");
//            }
//
//            System.out.println(indentation + "[" + node.name + "]");
//            Collections.sort(node.children, (n1, n2) -> n1.name.compareToIgnoreCase(n2.name));
//            for (Node child : node.children) {
//                displayHierarchy(child, depth + 1);
//            }
//        }
//    }
//}