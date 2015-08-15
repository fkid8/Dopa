package com.dopa;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class DopaDaoGenerator {


    DopaDaoGenerator Dopadb;

    public DopaDaoGenerator() {


    }


    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.kuviam.dopa.model");


        //Run table
        Entity run = schema.addEntity("Run");
        run.addIdProperty().autoincrement();
        run.addStringProperty("discipline").notNull();
        run.addStringProperty("locus");
        run.addIntProperty("no_of_items");
        run.addFloatProperty("practice_time");
        run.addFloatProperty("recall_time");
        run.addFloatProperty("assigned_practice_time");
        run.addFloatProperty("assigned_recall_time");
        run.addStringProperty("status");
        run.addFloatProperty("per_practice_time");
        run.addFloatProperty("per_recall_time");
        run.addDateProperty("start_timestamp");

        //Run_Item_list table
        Entity runitemlist = schema.addEntity("Run_discipline_item_list");
        runitemlist.addIdProperty().autoincrement();
        runitemlist.addIntProperty("discipline_item").notNull();
        runitemlist.addIntProperty("recall_attempt");
        runitemlist.addIntProperty("practice_attempt");
        Property runId = runitemlist.addLongProperty("runId").notNull().getProperty();
        runitemlist.addToOne(run, runId);
        runitemlist.addBooleanProperty("Status");
        runitemlist.addFloatProperty("practice_time");
        runitemlist.addFloatProperty("recall_time");
        //Locus table
        Entity locus = schema.addEntity("Locus");
        locus.addIdProperty().autoincrement();
        locus.addStringProperty("name").unique().notNull();
        locus.addStringProperty("creator");
        locus.addStringProperty("type");

        //Locus Text type table
        Entity locus_text_list = schema.addEntity("Locus_text_list");
        locus_text_list.addIdProperty().autoincrement();
        Property locusId1 = locus_text_list.addLongProperty("locusId").notNull().getProperty();
        locus_text_list.addToOne(locus, locusId1);
        locus_text_list.addStringProperty("item").unique().notNull();

        //Locus image type table
        Entity locus_image_list = schema.addEntity("Locus_image_list");
        locus_image_list.addIdProperty().autoincrement();
        Property locusId2 = locus_image_list.addLongProperty("locusId").notNull().getProperty();
        locus_image_list.addToOne(locus, locusId2);
        locus_image_list.addByteArrayProperty("item").unique().notNull();

        //Locus sound type table
        Entity locus_sound_list = schema.addEntity("Locus_sound_list");
        locus_sound_list.addIdProperty().autoincrement();
        Property locusId3 = locus_sound_list.addLongProperty("locusId").notNull().getProperty();
        locus_sound_list.addToOne(locus, locusId3);
        locus_sound_list.addByteArrayProperty("item").unique().notNull();

        //Locus sound type table
        Entity locus_number_list = schema.addEntity("Locus_number_list");
        locus_number_list.addIdProperty().autoincrement();
        Property locusId4 = locus_number_list.addLongProperty("locusId").notNull().getProperty();
        locus_number_list.addToOne(locus, locusId4);
        locus_number_list.addLongProperty("item").unique().notNull();

        //Discipline table
        Entity discipline = schema.addEntity("Discipline");
        discipline.addIdProperty().autoincrement();
        discipline.addStringProperty("name").unique().notNull();
        discipline.addIntProperty("no_of_items").notNull();
        discipline.addStringProperty("creator");
        discipline.addBooleanProperty("is_Ordered");
        discipline.addFloatProperty("practice_time");
        discipline.addFloatProperty("recall_time");
        discipline.addFloatProperty("per_practice_time");
        discipline.addFloatProperty("per_recall_time");

        //Discipline Text type table
        Entity discipline_text_list = schema.addEntity("Discipline_text_list");
        discipline_text_list.addIdProperty().autoincrement();
        Property disciplineId1 = discipline_text_list.addLongProperty("locusId").notNull().getProperty();
        discipline_text_list.addToOne(discipline, disciplineId1);
        discipline_text_list.addStringProperty("item").unique().notNull();

        //Discipline image type table
        Entity discipline_image_list = schema.addEntity("Discipline_image_list");
        discipline_image_list.addIdProperty().autoincrement();
        Property disciplineId2 = discipline_image_list.addLongProperty("locusId").notNull().getProperty();
        discipline_image_list.addToOne(discipline, disciplineId2);
        discipline_image_list.addByteArrayProperty("item").unique().notNull();

        //Discipline sound type table
        Entity discipline_sound_list = schema.addEntity("Discipline_sound_list");
        discipline_sound_list.addIdProperty().autoincrement();
        Property disciplineId3 = discipline_sound_list.addLongProperty("locusId").notNull().getProperty();
        discipline_sound_list.addToOne(discipline, disciplineId3);
        discipline_sound_list.addByteArrayProperty("item").unique().notNull();

        //Discipline sound type table
        Entity discipline_number_list = schema.addEntity("Discipline_number_list");
        discipline_number_list.addIdProperty().autoincrement();
        Property disciplineId4 = discipline_number_list.addLongProperty("locusId").notNull().getProperty();
        discipline_number_list.addToOne(discipline, disciplineId4);
        discipline_number_list.addLongProperty("item").unique().notNull();

        //Generate all tables

        new DaoGenerator().generateAll(schema, "app/src/main/java");
    }


}
