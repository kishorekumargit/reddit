package reddit;

import com.google.gson.JsonObject;

import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Storage {
        protected static ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
        protected static ConcurrentHashMap<String, Like> likes = new ConcurrentHashMap<>();
        protected static CopyOnWriteArrayList<String> registeredEmails = new CopyOnWriteArrayList<>();
        protected static ConcurrentHashMap<String, Posts> posts = new ConcurrentHashMap<>();
        protected static ConcurrentHashMap<String, Comments> comments = new ConcurrentHashMap<>();
        protected static ConcurrentHashMap<String, ConcurrentHashMap<String, Comments>> commentsByPostId = new ConcurrentHashMap<>();
        protected static ConcurrentHashMap<String, ConcurrentHashMap<String, Like>> likesByContentId = new ConcurrentHashMap<>();
        protected static ConcurrentLinkedQueue<String> newCommentQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentLinkedQueue<String> newPostQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentLinkedQueue<String> editCommentQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentLinkedQueue<String> editPostQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentLinkedQueue<String> newLikeQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentLinkedQueue<String> editLikeQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentHashMap<String, JsonObject> messages = new ConcurrentHashMap<>();
        protected static ConcurrentLinkedQueue<String> MessagesQueue = new ConcurrentLinkedQueue<>();
        protected static ConcurrentHashMap<String, Conversation> conversations = new ConcurrentHashMap<>();
        static {
            TimerSchedule t1 = new TimerSchedule("Task");
            Timer t = new Timer();
            t.scheduleAtFixedRate(t1, 0, 1000);
        }
}


