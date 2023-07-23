package org.example.dirwatcher;

import org.example.exception.ImportMustBeAFileException;
import org.example.util.ExMessage;
import org.example.util.OverWatch;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.*;

public class WatchDir {

    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;

    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>) event;
    }

    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        keys.put(key, dir);
    }

    public WatchDir(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<>();

        register(dir);
    }

    private void doExecute(WatchEvent<?> event, Runnable execution, Path dir) {
        WatchEvent<Path> ev = cast(event);
        Path name = ev.context();
        Path child = dir.resolve(name);

        if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
            throw new ImportMustBeAFileException(ExMessage.IMPORTED_ITEM_MUST_BE_A_FILE);
        }
        OverWatch.getInstance().setFilePath(child.toString());
        execution.run();
    }

    public void processEvents(Runnable execution) {
        while (true) {

            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                return;
            }

            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println(ExMessage.WATCH_KEY_NOT_RECOGNISED);
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == ENTRY_CREATE) {
                    try {
                        doExecute(event, execution, dir);
                    } catch (ImportMustBeAFileException e) {
                        e.printStackTrace();
                    }
                }
            }

            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);

                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }
}
