package com.adventofcode.day7;

import java.util.ArrayList;
import java.util.List;

public class File implements Comparable<File> {
    private String name;
    private long size;
    private FileType type;
    private List<File> files;

    private File parent;

    public File() {
        this.files = new ArrayList<>();
    }

    public File(String name, long size, FileType type, File parent) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.files = new ArrayList<>();
        this.parent = parent;
    }

    public boolean isDirectory() {
        return this.type == FileType.DIRECTORY;
    }

    public boolean isFile() {
        return this.type == FileType.FILE;
    }

    public File getParent() {
        return parent;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public void showStructure(int level) {
        StringBuilder margin = new StringBuilder();
        for (int i = 0; i < level; i++) margin.append("   ");

        if (type == FileType.FILE) {
            System.out.println(margin + "- " + name + " (file, size=" + this.size + ")");
        } else {
            System.out.println(margin + "- " + name + " (dir, size=" + this.size + ")");

            for (File file : files) {
                file.showStructure(level + 1);
            }
        }
    }

    public long countSizeOfDictionariesSizeSmallerThen(long size) {
        long sum = 0;
        if (this.size > 0 && this.size < size && type == FileType.DIRECTORY) {
            sum += this.size;
        }
        if (type == FileType.DIRECTORY) {
            for (File file : files) {
                sum += file.countSizeOfDictionariesSizeSmallerThen(size);
            }
        }
        return sum;
    }


    @Override
    public String toString() {
        return "Name: " + name + " size: " + size + " type: " + type;
    }

    public long updateDirectorySize() {
        if (this.isDirectory()) {
            this.size = 0;
            for (File file : files) {
                if (file.isFile()) {
                    this.size += file.size;
                } else {
                    this.size += file.updateDirectorySize();
                }
            }
        }
        return this.size;
    }

    public File findDirectoryByName(String name) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }

    public List<File> findAllDirectories() {
        List<File> allDirectories = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                allDirectories.add(file);
                allDirectories.addAll(file.findAllDirectories());
            }
        }
        return allDirectories;
    }

    @Override
    public int compareTo(File o) {
        return Long.compare(this.getSize(), o.getSize());
    }
}
