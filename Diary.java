import java.util.ArrayList;
import java.util.List;

public class Diary {
    private List<DiaryEntry> entries = new ArrayList<>();

    public void addEntry(DiaryEntry entry) {
        entries.add(entry);
    }

    public List<DiaryEntry> viewEntries() {
        return entries;
    }

    public void editEntry(int index, String newContent) {
        if (index >= 0 && index < entries.size()) {
            entries.get(index).setContent(newContent);
        }
    }

    public void deleteEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
        }
    }

    public List<DiaryEntry> searchEntries(String keyword) {
        List<DiaryEntry> result = new ArrayList<>();
        for (DiaryEntry entry : entries) {
            if (entry.getTitle().contains(keyword) || entry.getContent().contains(keyword)) {
                result.add(entry);
            }
        }
        return result;
    }
}
