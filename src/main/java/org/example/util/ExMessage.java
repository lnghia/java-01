package org.example.util;

public class ExMessage {

  private ExMessage() {}

  public static final String NO_MAPPER_FOUND_FOR_FILE_TYPE =
      "No corresponding mapper found for file type %s";

  public static final String ERROR_WATCHING_DIRECTORY_FOR_CHANGES =
      "There is an error in attempt to watch directory %s for changes.";

  public static final String FILESYSTEM_DOES_NOT_SUPPORT_WATCHING_OBJECTS_FOR_CHANGES =
      "This FileSystem does not support watching file system objects for changes and events.";

  public static final String DIRECTORY_WATCHER_GOT_INTERRUPTED =
      "Directory watcher service got interrupted while waiting.";
}
