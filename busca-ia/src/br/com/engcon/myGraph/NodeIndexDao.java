package br.com.engcon.myGraph;


import br.com.engcon.graph.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class NodeIndexDao
{
    private static HashMap<String,Integer> myNodes = new HashMap<>();

    public void inserir(Node n, int i) throws Exception {
        myNodes.put(n.getId(),i);

    }
    public static void createTxt(String dataset) {

        try {

            File statText = new File("D:\\Faculdade\\Grafos\\grafos\\busca-ia\\MyGraph Data\\" + dataset + ".txt");
            FileOutputStream is = null;
            is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.close();
        } catch (Exception e1) {
            e1.printStackTrace();

        }

    }
    public static void gravarDados(ArrayList<Node> list, String dataset) throws Exception {


        File f = new File("D:\\Faculdade\\Grafos\\grafos\\busca-ia\\MyGraph Data\\"+dataset+".txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);

            bw = new BufferedWriter(fw);
            int i=0;
            for(Node n : list) {
                bw.write(i+";"+n.getId());
                i++;
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void gravarDados2(ArrayList<String> list, String dataset) throws Exception {


        File f = new File("D:\\Faculdade\\Grafos\\grafos\\busca-ia\\MyGraph Data\\"+dataset+".txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);

            bw = new BufferedWriter(fw);
            int i=0;
            for(String n : list) {
                bw.write(i+";"+n);
                i++;
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static HashMap<String, Integer> getMyNodes(String dataset) throws Exception{
        File f = new File("D:\\Faculdade\\Grafos\\grafos\\busca-ia\\MyGraph Data\\"+dataset+".txt");

        FileReader fr = null;

        BufferedReader br = null;

        try {

            fr = new FileReader(f);

            br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                myNodes.put(dados[1],Integer.parseInt(dados[0]));

            }

        } catch (Exception e) {


            throw e;

        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return myNodes;
    }
}

